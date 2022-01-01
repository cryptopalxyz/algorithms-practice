package c6.动规.线性动规;

public class P309MaxStockProfitColdDownDG {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //0. move index to 1-based 可以去掉
        int[] pricesNew = new int[n + 1];
        pricesNew[0] = 0;
        for (int i = 1; i < n + 1; i++)
            pricesNew[i] = prices[i - 1];

        //1. define f, initialize 负无穷
        int[][][] f = new int[n + 1][2][2];

        for (int i=0;i<n+1;i++)
            for (int j=0;j<2;j++)
                for (int k=0;k<2;k++)
                    f[i][j][k] = -9999999;

        f[0][0][0] = 0;
        //2. 动规 loop over all states
        for (int i = 1; i < n + 1; i++)
            for (int j = 0; j < 2; j++) //0或者1表示买或者卖
                for (int k=0; k<2; k++) { //冷冻期
                    //3. 转移方程
                    f[i][1][0] = Math.max(f[i][1][0], f[i-1][0][0] - pricesNew[i]);//没股票，没冷冻，买
                    f[i][0][1] = Math.max(f[i][0][1], f[i-1][1][0] + pricesNew[i]);//卖出冷冻，获得收益price
                    f[i][j][0] = Math.max(f[i][j][0], f[i-1][j][k]);//啥也不干，冷冻期解除
                }
        //4。返回目标
        return Math.max(f[n][0][0],f[n][0][1]);//末尾0，1表示在冷冻期，在不在都可以，所以取max
    }
}


/*
309. 最佳买卖股票时机含冷冻期
给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
示例:

输入: [1,2,3,0,2]
输出: 3
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]

 */
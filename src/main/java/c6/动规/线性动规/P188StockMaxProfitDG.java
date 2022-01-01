package c6.动规.线性动规;

import java.util.Arrays;

/*
只买入一次
卖出一次
1.前缀min，固定j，再前面选择一个最小的i，O(n)解决
 */
public class P188StockMaxProfitDG {
    public int maxProfit(int c, int[] prices) {
        int n = prices.length;
        //0. move index to 1-based 可以去掉
        int[] pricesNew = new int[n + 1];
        pricesNew[0] = 0;
        for (int i = 1; i < n + 1; i++)
            pricesNew[i] = prices[i - 1];

        //1. define f, initialize 负无穷
        int[][][] f = new int[n + 1][2][c+1];
        //int[][]f = new int[n+1][2];
        //Arrays.fill(f, 0);
        //for (int[] f1: f)
        //Arrays.fill(f1, -2147483648);
        //Arrays.fill(f[0][0], -100000000);
        //Arrays.fill(f[0][1], -100000000);
        for (int i=0;i<n+1;i++)
            for (int j=0;j<2;j++)
                for (int k=0;k<c+1;k++)
                    f[i][j][k] = -9999999;

        f[0][0][0] = 0;
        //2. 动规 loop over all states
        for (int i = 1; i < n + 1; i++)
            for (int j = 0; j < 2; j++) //0或者1表示买或者卖
                for (int k=0; k<c+1; k++) {
                //3. 转移方程
                if (k>0) f[i][1][k] = Math.max(f[i][1][k], f[i-1][0][k-1] - pricesNew[i]);//买
                f[i][0][k] = Math.max(f[i][0][k], f[i-1][1][k] + pricesNew[i]);//卖
                f[i][j][k] = Math.max(f[i][j][k], f[i-1][j][k]);//啥也不干
            }
        //4。返回目标
        int ans = 0;
        for (int k=0; k<c+1;k++)
            ans = Math.max(ans, f[n][0][k]);
        return ans;
    }
}

class SolutionP188DG {
    public static void main(String[] args) {
        int[] prices = {2,4,1};
        int k =2;
        P188StockMaxProfitDG p = new P188StockMaxProfitDG();
        p.maxProfit(k, prices);
    }
}

/*
188. 买卖股票的最佳时机 IV
给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。



示例 1：

输入：k = 2, prices = [2,4,1]
输出：2
解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
示例 2：

输入：k = 2, prices = [3,2,6,5,0,3]
输出：7
解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。


提示：

0 <= k <= 100
0 <= prices.length <= 1000
0 <= prices[i] <= 1000


 */
package c6.动规.线性动规;

public class P714MaxStockProfitFeeDG {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        //0. move index to 1-based 可以去掉
        int[] pricesNew = new int[n + 1];
        pricesNew[0] = 0;
        for (int i = 1; i < n + 1; i++)
            pricesNew[i] = prices[i - 1];

        //1. define f, initialize 负无穷
        int[][] f = new int[n + 1][2];
        //Arrays.fill(f, 0);
        //for (int[] f1: f)
        //Arrays.fill(f1, -2147483648);

        for (int i=0;i<n+1;i++)
            for (int j=0;j<2;j++)
                f[i][j] = -2147483648;

        f[0][0] = 0;
        //2. 动规 loop over all states
        for (int i = 1; i < n + 1; i++)
            for (int j = 0; j < 2; j++) { //0或者1表示买或者卖
                //3. 转移方程
                f[i][1] = Math.max(f[i][1], f[i-1][0] - pricesNew[i] - fee);//买，买卖一次有fee，fee不是状态
                f[i][0] = Math.max(f[i][0], f[i-1][1] + pricesNew[i]);//卖
                f[i][j] = Math.max(f[i][j], f[i-1][j]);//啥也不干
            }
        //4。返回目标
        return f[n][0];
    }
}

package c6.贪心;

/*
蛮力n的3次方，因为有3个选择，买，卖，不动
聪明的做法：看第二天，第二天涨就持有，跌就卖，
空仓也看第二天，如果涨就买，跌就不买
这样就能获得完美结果price[i] - price[i-1]的收益

代码实现上可以直接实现完美结果，采用另一个逻辑
 */
public class P122StockMaxProfit {
    int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++)
            ans += Math.max(prices[i] - prices[i - 1], 0);
        return ans;
    }
}

package c6.贪心;

import java.util.Arrays;

/*
DP
贪心不行，因为贪心是局部最优解，这个题不能证明作为全局最优解

求"兑换这个金额所需的最少硬币数"
原始状态：剩余金额，已用硬币，目标：到达终点
新状态：剩余金额，最优化目标，硬币枚数最少
推导关系："兑换n元的最少硬币枚数" opt(n) = min( opt(n-1), opt(n-9), opt(n-10)) + 1
 */
public class P322CoinChange {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);//默认从小到大
        int INF = (int)1e9;
        int[] opt = new int[amount + 1];
        opt[0] = 0;
        for (int i =1; i<= amount; i++) {
            opt[i] = INF;
            for (int j=0; j<coins.length; j++)
                if (i-coins[j] >=0 )
                    opt[i] = Math.min(opt[i], opt[i-coins[j]]+1);
        }
        if (opt[amount] >= INF) opt[amount] = -1;
        return opt[amount];
    }

}


/*
322. 零钱兑换
给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。

计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。

你可以认为每种硬币的数量是无限的。



示例 1：

输入：coins = [1, 2, 5], amount = 11
输出：3
解释：11 = 5 + 5 + 1
示例 2：

输入：coins = [2], amount = 3
输出：-1
示例 3：

输入：coins = [1], amount = 0
输出：0
示例 4：

输入：coins = [1], amount = 1
输出：1
示例 5：

输入：coins = [1], amount = 2
输出：2
 */
package c2.前缀和;

import java.util.HashMap;

/*
原问题：子段的奇数数量
新问题：奇数看作0，偶数看作1，（每个数mod2），统计子段和是K的子段数量
 */
public class P1248CountingNiceSubArrays {
    //nums {1, 1, 2, 1, 1}
    public int numberOfSubarrays(int[] nums, int k) {
        int[] s = new int[nums.length + 1 ];
        s[0] = 0;
        int ans = 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);//看不懂 这是为什么？
        //s[i]表示i（包括i）前面有几个奇数
        //{0, 1, 2, 2, 3, 4}
        //s[0] = nums[0]%2;
        for (int i = 1; i < nums.length + 1; i++)
            s[i] = s[i - 1] + nums[i - 1]%2;


        //count表示下标为s[i]的数字出现的次数。
        //{1, 1, 2, 1, 1, 0}
        //下标是「前缀和」，值是「前缀和的个数」）

        for (int i = 1; i < nums.length + 1; i++) {
            if (map.containsKey(s[i] - k)) {
                ans += map.get(s[i] - k);
            }
            map.put(s[i], map.getOrDefault(s[i],0)+1);
        }
        return ans;

    }
}

class SolutionP1248 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        P1248CountingNiceSubArrays p = new P1248CountingNiceSubArrays();
        p.numberOfSubarrays(nums, 3);

    }
}

/*

1248. 统计「优美子数组」
给你一个整数数组 nums 和一个整数 k。

如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。

请返回这个数组中「优美子数组」的数目。



示例 1：

输入：nums = [1,1,2,1,1], k = 3
输出：2
解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
示例 2：

输入：nums = [2,4,6], k = 1
输出：0
解释：数列中不包含任何奇数，所以不存在优美子数组。
示例 3：

输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
输出：16
 */
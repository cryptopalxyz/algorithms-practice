package c2.homework;

import java.util.HashMap;
import java.util.Map;

/*

前缀和再配合哈希表
由于只关心次数，不关心具体的解，我们可以使用哈希表加速运算；
由于保存了之前相同前缀和的个数，计算区间总数的时候不是一个一个地加，时间复杂度降到了 O(N) 。


 */
public class P560SubArraySumEqualsKOptimizedAgain {
    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        int n = nums.length;
        int ans = 0;

        //对于下标为 0 的元素，前缀和为 0，个数为 1
        map.put(0,1);
        //计算前缀和
        int preSum = 0;
        int count = 0;
        for (int num: nums) {
            preSum += num ;
            if (map.containsKey( preSum  - k))
                count += map.get(preSum - k);

            map.put(preSum, map.getOrDefault(preSum, 0) + 1);

        }
        return  count;
    }


}

class SolutionP560SubArraySumEqualsKOptimizedAgain {
    public static void main(String[] args) {
        P560SubArraySumEqualsKOptimizedAgain p = new P560SubArraySumEqualsKOptimizedAgain();
        int[] nums = { -1, -1, 1};
        p.subarraySum(nums, 0);
    }
}

/*
给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。

 

示例 1：

输入：nums = [1,1,1], k = 2
输出：2
示例 2：

输入：nums = [1,2,3], k = 3
输出：2
 

提示：

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
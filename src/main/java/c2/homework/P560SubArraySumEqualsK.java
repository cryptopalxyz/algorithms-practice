package c2.homework;

/*
暴力解法： 从i=0 j=0双重循环 arraySum三重循环
超出时间限制
 */
public class P560SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++) {
                if (arraySum(nums, i, j) == k) {
                    ans++;
                }
            }
        return ans;
    }

    int arraySum(int[] nums, int m, int k) {
        int res = 0;
        for (int i = m; i <= k; i++)
            res += nums[i];

        return res;
    }
}

class SolutionP560 {
    public static void main(String[] args) {
        P560SubArraySumEqualsK p = new P560SubArraySumEqualsK();
        int[] nums = { };
        p.subarraySum(nums, -93);
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
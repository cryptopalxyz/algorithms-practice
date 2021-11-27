package c2.homework;

/*
1.计算前缀和
1  1  1
1  2  3
2.求子段差=k的个数
3-1=2
2=k

o(n*n)

1  2  3
1  3  6
3=3
6-3=3

1 -1 0
1  0 0
0 = 0
0=0
0-0=0

1  2  1  2  1
1  3  4  6  7

3=3
4-1=3
6-3=3
7-4=3

-1  -1  1
-1  -2  -1

-1 -(-1) =0


 */
public class P560SubArraySumEqualsKOptimized {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int [] s = new int[n];
        s[0] = nums[0];
        //计算前缀和
        for (int i = 1; i < n; i++)
            s[i] = nums[i] + s[i-1];

        //计算子段和，或者子段和的差
        for (int i=0; i<n; i++)
            for (int j=i; j<n; j++) {
                if ( i==j && s[j]  == k) ans++;
                if (j>i && s[j] - s[i] == k) ans++;
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

class SolutionP560SubArraySumEqualsKOptimized {
    public static void main(String[] args) {
        P560SubArraySumEqualsKOptimized p = new P560SubArraySumEqualsKOptimized();
        int[] nums = { 1, 2, 3};
        p.subarraySum(nums, 3);
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
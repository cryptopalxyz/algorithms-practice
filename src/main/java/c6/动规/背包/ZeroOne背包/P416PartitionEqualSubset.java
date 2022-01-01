package c6.动规.背包.ZeroOne背包;

public class P416PartitionEqualSubset {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int[] numsNew = new int[n+1];
        numsNew[0]=0;
        for (int i=1;i<n+1;i++) numsNew[i] = nums[i-1];
        for (int i=0;i<n;i++) sum += nums[i];
        if ( sum%2 == 1 )return false;

        boolean[] f = new boolean[sum/2+1];
        f[0] = true;
        for (int i=1;i<sum/2;i++)
            f[i] = false;
        //f[i][j]前i个数，使得总和==j是否可行
        //选f[i][j] = f[i-1][j - nums[i]] || f[i-1][j]
        //f[i][j] = f[i-1][j-nums[i]] || f[i-1][j]
        for (int i=1;i<n+1;i++)
            for (int j=sum/2; j>=nums[i];j--) {
                f[j] |= f[j - nums[i]]; // |= 位于运算bitwise
            }

        return f[sum/2]; //看是不是true
    }

}


/*
416. 分割等和子集
给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。



示例 1：

输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。
示例 2：

输入：nums = [1,2,3,5]
输出：false
解释：数组不能分割成两个元素和相等的子集。


提示：

1 <= nums.length <= 200
1 <= nums[i] <= 100

 */
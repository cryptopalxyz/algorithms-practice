package c2.前缀和;

//求最大的子段和
/*
暴力解法：
1。先求前缀和
2。循环s[r]-s[l]取最大 O(n2)

如果不用前缀和，直接2重循环+求和，O(n3)

用前缀最小值，枚举右侧，

 */
public class P53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] s = new int[nums.length + 1];

        int[] preMin = new int[nums.length + 1];

        s[0] = 0;
        for (int i = 1; i < nums.length + 1; i++)
            s[i] = s[i - 1] + nums[i - 1];
        preMin[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            preMin[i] = Math.min(s[i], preMin[i - 1]);
        }
        //够小了
        int ans = -100000;
        for (int i = 1; i < nums.length + 1; i++) {
            //s[i] - preMin[i-1] s[i]减去一个最小的，得到最大的值
            ans = Math.max(ans, s[i] - preMin[i - 1]);
        }
        return  ans;

    }
}

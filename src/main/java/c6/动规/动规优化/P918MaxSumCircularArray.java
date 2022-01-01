package c6.动规.动规优化;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*

环形，可以把原数组复制一次，接在后面

 */
public class P918MaxSumCircularArray {
    public int maxSubarraySumCircular(int[] nums) {
        /* 线性的最大值，用最小的前缀和求
        int n = nums.length;
        int[] s = new int[n+1];
        Arrays.fill(s, 0);
        s[0] = 0;
        for (int i =1; i<n+1; i++) {
            s[i] = s[i-1] + nums[i-1]; //前缀和
        }
        int ans = -1000000;
        int temp = -1000000;//求前缀和min
        for (int i=2; i<n+1;i++) {
            temp = Math.min(temp, s[i-1]);
            ans = Math.max(ans, s[i] - temp);
        }

        return ans;

        */

        int n = nums.length;
        int[] ss = new int[2*n+1];
        ss[0]=0;
        Arrays.fill(ss, 0);
        for (int i=1; i<n+1; i++)
            ss[i] = ss[i-1] + nums[i-1];

        //复制的前缀和继续计算
        for (int i=n+1; i<2*n+1; i++)
            ss[i] = ss[i-1] + nums[i-1-n];

        Deque<Integer> q = new LinkedList();
        int ans = -100000;
        //i-n <=j <=i-1里面求滑动窗口最小值
        //这下吗的逻辑错了
        for( int i=1; i<2*n+1; i++) {
            while (!q.isEmpty() && q.peekFirst() < i -n) q.removeFirst();
            if (!q.isEmpty()) ans = Math.max(ans, ss[i] - ss[q.peekFirst()]);
            while (!q.isEmpty() && ss[q.peekLast()] >= ss[i]) q.removeLast();
            q.push(i);
        }
        return ans;
    }
}


/*

918. 环形子数组的最大和
给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。

在此处，环形数组意味着数组的末端将会与开头相连呈环状。（形式上，当0 <= i < A.length 时 C[i] = A[i]，且当 i >= 0 时 C[i+A.length] = C[i]）

此外，子数组最多只能包含固定缓冲区 A 中的每个元素一次。（形式上，对于子数组 C[i], C[i+1], ..., C[j]，不存在 i <= k1, k2 <= j 其中 k1 % A.length = k2 % A.length）



示例 1：

输入：[1,-2,3,-2]
输出：3
解释：从子数组 [3] 得到最大和 3
示例 2：

输入：[5,-3,5]
输出：10
解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
示例 3：

输入：[3,-1,2,-1]
输出：4
解释：从子数组 [2,-1,3] 得到最大和 2 + (-1) + 3 = 4
示例 4：

输入：[3,-2,2,-3]
输出：3
解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
示例 5：

输入：[-2,-3,-1]
输出：-1
解释：从子数组 [-1] 得到最大和 -1

 */
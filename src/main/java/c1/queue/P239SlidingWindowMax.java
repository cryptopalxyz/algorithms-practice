package c1.queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//最优解，递减才行
//单调队列是 递减的
/*
单调队列套路
维护一个候选集合，前面的比较旧，后面的比较新
候选项的属性也具有单调性
确定递增递减的方法-考虑j1，j2，写出j1<j2的条件

排除冗余的关键：若j1比j2差，j1的生命周期还比j2短，则j1就没用了

for 每个元素
  1while（队尾过期）对尾出队
  2取队尾为最佳选项，计算答案
  3while（队尾与新元素不满足单调性） 队尾出队 2/3的顺序取决i是不是候选项
  4新元素入队

把出界的老元素去掉；
老元素还有用（比新的大），就留着，没有用的话就while去掉；
把新的放到对头；
没轮从队尾取最大值
 */
public class P239SlidingWindowMax {
    //下标（时间）递减，用removeLast来移除过界元素
    //值递增的队列，用peekLast来获取最大元素
    public int[] maxSlidingWindow(int[] nums, int k) {


        List<Integer> ans = new ArrayList<>();
        //下标
        Deque<Integer> q = new LinkedList<>();
        for (int i=0; i<nums.length; i++) {
            //q里面的下标是递减的，队尾先出界
            while (!q.isEmpty() && q.peekLast() <= i - k) q.removeLast(); //删除掉出界的
            //插入新选项，维护单调性,大的来了，并且生命周期更长，把小的全扔掉，从队头扔掉
            //如果没扔掉，说明新来的比旧的还小，新来的加到对头
            while (!q.isEmpty() && nums[q.peekFirst()] <= nums[i]) q.removeFirst();
            //加到对头，维护的是下标（时间）递减的队列
            q.push(i);

            //取队头，更新答案
            if (i >= k - 1) {
                ans.add(nums[q.peekLast()]);
            }
        }

        int[] a = new int[ans.size()];
        for (int i=0; i<ans.size();i++)
            a[i] = ans.get(i);

        return a;
    }
}

class SolutionP239SlidingWindowMax {
    public static void main(String[] args) {
        int [] nums = {1,3,-1,-3,5,3,6,7};
        P239SlidingWindowMax p = new P239SlidingWindowMax();
        p.maxSlidingWindow(nums, 3);
    }
}

/*

给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回滑动窗口中的最大值。

 

示例 1：

输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
输出：[3,3,5,5,6,7]
解释：
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
示例 2：

输入：nums = [1], k = 1
输出：[1]
示例 3：

输入：nums = [1,-1], k = 1
输出：[1,-1]
示例 4：

输入：nums = [9,11], k = 2
输出：[11]
示例 5：

输入：nums = [4,-2], k = 2
输出：[4]
 

提示：

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sliding-window-maximum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
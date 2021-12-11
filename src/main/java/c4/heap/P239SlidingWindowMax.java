package c4.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*

堆天然支持插入，删除，取最值

用最大堆，堆顶是最大值，假如过期的元素不是堆顶， 对堆的最大值没有影响，就不删，lazy方式，
如果没删的值成了堆顶，就删除
pass
 */
public class P239SlidingWindowMax {


    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> q = new PriorityQueue<>(nums.length,
                new Comparator<Pair>() {
                    public int compare(Pair s1, Pair s2) {
                        return s2.first - s1.first;
                        //return s2.key - s1.key 是大根堆
                    }
                });
        for (int i=0; i<nums.length; i++) {
            q.add(new Pair(nums[i], i));
            if (i>=k-1 ) {// 有k-1个，开始选最大值
                // [i-k+1, i] 把不合法的都删掉，直到合法为止
                //如果堆顶的下标second是过期的，那么就poll掉，不然就留着
                while (q.peek().second <= i-k)
                    q.poll();
                ans.add(q.peek().first);//答案

            }
        }
        int[] result = new int[ans.size()];
        for (int i=0;i<ans.size(); i++)
            result[i] = ans.get(i);
        return result;
    }
}

class Pair {
    int first;
    int second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

}


class SolutionP239 {
    public static void main(String[] args) {
        int [] nums = {1,3,-1,-3,5,3,6,7};
        int k =3;
        P239SlidingWindowMax p = new P239SlidingWindowMax();
        p.maxSlidingWindow(nums,k);
    }
}

/*

239. 滑动窗口最大值
给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

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


 */

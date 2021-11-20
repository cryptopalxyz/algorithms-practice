package c1.stack;

import java.util.Deque;
import java.util.LinkedList;


//确定递增递减，关键在于考虑"前面不能影响到后面"的条件
//本题中如果h[i-1]>h[i]，则h[i]这个高度就无法影响到后面，可以单独计算
/*
单调栈题目代码思路
for 每个元素
 while（栈顶与新元素不满足单调性） {弹栈，更新答案，累加宽度}
 入栈

 */
public class P84LargestRectangleInHistogram {
    class Rect {
        int width;
        int height;
        public Rect(int width, int height) {
            this.width = width;
            this.height = height;
        };
    }

    public int largestRectangleArea(int[] heights) {
        Deque<Rect> s = new LinkedList<>();
        int ans = 0;
        int [] h = new int[heights.length + 1];
        for (int i=0; i<heights.length; i++) {
            h[i] = heights[i];
        }
        h[heights.length] = 0;//放一个0保证栈被弹空？
        for( int height: h) {
            int accumulatedWidth = 0;
            //满足单调性
            //栈顶（之前）高度>=当前高度，说明单调性破坏，确定栈顶高度扩展范围，
            // 需要删除,累计宽度，
            while (!s.isEmpty() && s.peek().height >= height) {
                accumulatedWidth += s.peek().width;
                ans = Math.max(ans, s.peek().height * accumulatedWidth);
                s.pop();
            }
            s.push(new Rect(accumulatedWidth + 1, height));

        }
        //栈里面剩下的是单调递增的块
        return ans;

    }


}
/*

给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。

 

示例 1:



输入：heights = [2,1,5,6,2,3]
输出：10
解释：最大的矩形为图中红色区域，面积为 10
示例 2：



输入： heights = [2,4]
输出： 4
 

提示：

1 <= heights.length <=105
0 <= heights[i] <= 104

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
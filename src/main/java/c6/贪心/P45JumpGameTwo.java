package c6.贪心;

/*
继续往后看两步，
看下一步能到的最远的位置
如果nums[i]-nums[i-1]>1,就去i，不然直接跳
 */
public class P45JumpGameTwo {
    public int jump(int[] nums) {
        //下标，范围0~length-1
        int now = 0;
        //跳了几次
        int ans = 0;
        while (now < nums.length - 1) {
            //[now + 1, right]可达范围
            int right = now + nums[now];
            //到了终点
            if (right >= nums.length - 1)
                return  ans + 1;
            int nextRight = right;
            int next = now;
            for (int i =now + 1; i<=right; i++) {
                //更远
               if ( i + nums[i] > nextRight)   {
                   nextRight = i + nums[i];
                   next = i;
               }
            }
            now = next;
            ans++;
        }

        return ans;
    }

}


class SolutionP45 {
    public static void main(String[] args) {
        P45JumpGameTwo p = new P45JumpGameTwo();
        int [] nums= {2,3,1,1,4};
        p.jump(nums);
    }
}
/*
45. 跳跃游戏 II
给你一个非负整数数组 nums ，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

假设你总是可以到达数组的最后一个位置。



示例 1:

输入: nums = [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
示例 2:

输入: nums = [2,3,0,1,4]
输出: 2


提示:

1 <= nums.length <= 104
0 <= nums[i] <= 1000

 */
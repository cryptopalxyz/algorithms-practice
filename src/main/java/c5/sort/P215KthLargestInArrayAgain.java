package c5.sort;

import java.util.Arrays;
import java.util.Collections;


/*

因为范围小
1 <= k <= nums.length <= 104
所以可以先排序

假如范围很大，几十亿，那么全部排序就不行
跳过！用快拍的思想

 */
public class P215KthLargestInArrayAgain {
    public int findKthLargest(int[] nums, int k) {

        /*
         * 注意，要想改变默认的排列顺序，不能使用基本类型（int,double,char）而要使用它们对应的类
         */

        //默认升序
        Integer[] integerNums = new Integer[nums.length];
        for (int i=0;i<nums.length;i++)
            integerNums[i] = nums[i];

        Arrays.sort(integerNums, Collections.reverseOrder()); //o(logn)

        return integerNums[k-1];

    }
}

class SolutionP215Again {
    public static void main(String[] args) {
        P215KthLargestInArray p = new P215KthLargestInArray();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        p.findKthLargest(nums, 4);
    }
}

/*
给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。

请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

 

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
 

提示：

1 <= k <= nums.length <= 104
-104 <= nums[i] <= 104


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
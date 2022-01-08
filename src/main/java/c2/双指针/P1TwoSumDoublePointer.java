package c2.双指针;

import java.util.Arrays;
import java.util.List;

//把下标和数值放在class里面一起排序
public class P1TwoSumDoublePointer {
    public int[] twoSum(int[] nums, int target) {
        ArrayClass[] ac = new ArrayClass[nums.length];
        System.out.println(ac.length);//NPE， why？
        for (int i=0;i<ac.length;i++)
            System.out.println(ac[i].value);
        ac[0].pointer = 1;
        ac[0].value = 1;
        for (int i=0;i<nums.length;i++) {
            ac[i].pointer = i;
            ac[i].value = nums[i];
        }
        //sort ac
        Arrays.sort(ac, (i, j)-> {return  i.value - j.value;}); //o(logn)
        //然后用双指针 O(n)
        return  null;


    }
}

class ArrayClass {
    int pointer;
    int value;
    ArrayClass(int pointer, int value) {
        this.pointer = pointer;
        this.value = value;
    }
}

class SolutionP1TwoSumDoublePointer {
    public static void main(String[] args) {
        P1TwoSumDoublePointer p1 = new P1TwoSumDoublePointer();
        int []nums = {2, 7, 11, 15};
        p1.twoSum(nums, 9);
    }
}

/*

1. 两数之和
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。



示例 1：

输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
示例 2：

输入：nums = [3,2,4], target = 6
输出：[1,2]
示例 3：

输入：nums = [3,3], target = 6
输出：[0,1]


 */
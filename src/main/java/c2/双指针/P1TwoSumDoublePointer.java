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
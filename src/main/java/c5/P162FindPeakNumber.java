package c5;

public class P162FindPeakNumber {
    public int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int lmid = (left + right ) /2;
            int rmid = lmid + 1;
            if (nums[lmid] <= nums[rmid])
                left = lmid + 1; //为什么+1？
            else
                right = rmid - 1; //此处为什么-1？为什么left+right不需要+1
        }

        return right;
    }
}

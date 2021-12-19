package c5;

public class P34FindFirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        //开始位置：第一个>=target的数
        //结束位置：最后一个<=target的数
        int[] ans = new int [2];

        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right)/2;
            if (nums[mid] >= target)
                right = mid;
            else
                left = mid + 1;
        }

        //这里right可能是nums.length,是个错误的数字
        ans[0] = right;

        //可能无解，变成-1
        left = -1;
        right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1 )/2;
            if (nums[mid] <= target)
                left = mid;
            else
                right = mid - 1;
        }
        //这里right可能是nums.length -1 ,是个正常的数字，不是错误的
        ans[1] = right;

        //不存在
        if (ans[0] > ans[1]) {
            ans[0] = -1;
            ans[1] = -1;
        }
        return ans;
    }
}

/*

34. 在排序数组中查找元素的第一个和最后一个位置
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 target，返回 [-1, -1]。

进阶：

你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？


示例 1：

输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
示例 2：

输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]
示例 3：

输入：nums = [], target = 0
输出：[-1,-1]

 */
package c2.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/*

外层循环i
内层调用两数只和，让内层等于target - nums[i]

 */
public class P153Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> two = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            two = twoSum(nums, i + 1, 0 - nums[i]);
            if (two != null && two.size() != 0) {
                for (List<Integer> t : two) {
                    list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(t.get(0));
                    list.add(t.get(1));
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    //不能立即返回，需要记录一个list
    public List<List<Integer>> twoSum(int[] nums, int k, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> oneAns = new ArrayList<>();
        for (int i = k; i < nums.length; i++) {
            List<Integer> dup = new ArrayList<>();
            dup.add(nums[i]);
            dup.add(target-nums[i-1]);
            if (i > k && (nums[i] == nums[i - 1]) && ans.contains(dup )) continue;//这一步能不能优化？
            if (map.containsKey(target - nums[i])) {
                oneAns = new ArrayList<>();
                oneAns.add(nums[i]);
                oneAns.add(target - nums[i]);
                ans.add(oneAns);
               // map = new HashMap<>();
            } else
                map.put(nums[i], i);
        }
        return ans;
    }
}

class SolutionP15 {
    public static void main(String[] args) {
        P153Sum p = new P153Sum();
        int[] nums = {-2,0,0,2,2};
        p.threeSum(nums);

    }
}


/*
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。

 

示例 1：

输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
示例 2：

输入：nums = []
输出：[]
示例 3：

输入：nums = [0]
输出：[]
 

提示：

0 <= nums.length <= 3000
-105 <= nums[i] <= 105

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
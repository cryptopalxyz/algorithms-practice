package c3.homework;

import c3.递归.全排列.P46Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*

nums可重复


 */
public class P47PermutationsTwo {


    List<Integer> a = new ArrayList<>();
    int n;
    List<List<Integer>> ans = new ArrayList<>();
    Boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        n = nums.length;
        used = new Boolean[nums.length];
        for (int i = 0; i < n; i++)
            used[i] = false;
        ans = new ArrayList<>();
        recur(nums, 0);
        return ans;
    }

    void recur(int[] nums, int pos) {
        if (pos == n) {
            //此处注意 不能是ans.add(a);
            ans.add(new ArrayList<Integer>(a));
            return;

        }
        for (int i = 0; i < n; i++) {
            //不重复的条件,没用过
            //或者 和前一个值相同，并且前一个没用过（还原现场之后）
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]))
                continue;
            a.add(nums[i]);
            used[i] = true;
            recur(nums, pos + 1);
            //还原现场
            a.remove(a.size() - 1);
            used[i] = false;
        }
    }
}




class SolutionP47 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        P47PermutationsTwo p = new P47PermutationsTwo();
        p.permuteUnique(nums);


    }
}
/*
47. 全排列 II
给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。



示例 1：

输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]
示例 2：

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

 */
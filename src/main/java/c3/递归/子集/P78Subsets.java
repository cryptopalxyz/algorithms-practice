package c3.递归.子集;

import java.util.ArrayList;
import java.util.List;


/*
暴力解法，简单O(N*N)
循环添加i到j的组合，j>=i
时间复杂度：O(n * 2 ^ n) 一共 2^n2 个状态，每种状态需要 O(n)  的时间来构造子集。
空间复杂度：O(n)O
        1
   2


 */
public class P78Subsets {

    //chosen是共享变量
    List<Integer> chosen = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int i, int[] nums) {
        if (i == nums.length) {
            ans.add(new ArrayList<Integer>(chosen));
            return;
        }
        //选
        chosen.add(nums[i]);
        dfs(i + 1, nums);
        //还原现场
        //不选
        chosen.remove(chosen.size() - 1 );
        dfs(i + 1 , nums);
    }

}

/*

给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

 

示例 1：

输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
示例 2：

输入：nums = [0]
输出：[[],[0]]
 

提示：

1 <= nums.length <= 10
-10 <= nums[i] <= 10
nums 中的所有元素 互不相同


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
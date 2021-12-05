package c3.递归.全排列;

import java.util.ArrayList;
import java.util.List;

/*
从没被选过的数里面选一个
nums里面数字不重复
 */
public class P46Permutations {



    List<Integer> a = new ArrayList<>();
    int n;
    List<List<Integer>> ans = new ArrayList<>();
    Boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        used = new Boolean[nums.length];
        for (int i=0;i<n;i++)
            used[i] = false;
        ans = new ArrayList<>();
        recur(nums,0);
        return  ans;
    }

    void recur(int[] nums, int pos) {
        if (pos==n) {
            //此处注意 不能是ans.add(a);
            ans.add(new ArrayList<Integer>(a));
            return;

        }
        for (int i=0; i<n; i++) {
            if (used[i])
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

class SolutionP46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        P46Permutations p = new P46Permutations();
        p.permute(nums);
    }
}
/*
给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。

 

示例 1：

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
示例 2：

输入：nums = [0,1]
输出：[[0,1],[1,0]]
示例 3：

输入：nums = [1]
输出：[[1]]
 

提示：

1 <= nums.length <= 6
-10 <= nums[i] <= 10
nums 中的所有整数 互不相同

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
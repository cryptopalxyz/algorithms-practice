package c3.递归.组合;

import java.util.ArrayList;
import java.util.List;

public class P77Combinations {

    List<Integer> chosen = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        //int [] nums = new int[n];
        //for (int i=0;i<n;i++)
           // nums[i]++;
        //题目是从1开始到n
        dfs(1, n, k);
        return ans;
    }

    public void dfs(int i, int n, int k) {
        //超过2个提前退出
        //最后剩下的加一起也不够
        if (chosen.size() >k || chosen.size() + (n-i+1) < 2 ) return;
        //递归边界
        if (i == n+1 ) {
            if (chosen.size() == k)
                ans.add(new ArrayList<Integer>(chosen));
            return;
        }

        chosen.add(i);
        //选
        dfs(i + 1, n, k);
        //还原现场
        chosen.remove(chosen.size() - 1 );
        //不选
        dfs(i + 1 , n, k);
    }
}

class SolutionP77 {
    public static void main(String[] args) {
        P77Combinations p = new P77Combinations();
        p.combine(4,2);

    }
}

/*
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

你可以按 任何顺序 返回答案。

 

示例 1：

输入：n = 4, k = 2
输出：
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
示例 2：

输入：n = 1, k = 1
输出：[[1]]
 

提示：

1 <= n <= 20
1 <= k <= n

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combinations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
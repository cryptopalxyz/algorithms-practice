package c4.DFS;

import java.lang.reflect.Array;
import java.util.*;

/*

i
j
i-j
i+j


 */
public class P51NQueens {

    List<Integer> p = new ArrayList<>();

    boolean [] used;
    Map<Integer, Boolean> usedPlus = new HashMap<>();
    Map<Integer, Boolean> usedMinus = new HashMap<>();
    int n;

    List<List<Integer>> ans = new ArrayList<>();
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        used = new boolean[n];
        for (int i =0;i<n;i++)
            used[i]=false;
        dfs(0);


        //打印出来

        String [] p1 = new String[n];
        List<String> oneElement = new ArrayList<>();
        //
        for (List<Integer> p: ans) {
            oneElement = new ArrayList<>();
            for (int row = 0; row < n; row++) {
                p1 = new String[n];
                Arrays.fill(p1, ".");
                p1[p.get(row)] = "Q";
                oneElement.add(String.join("", p1));
            }
            result.add(oneElement);
        }

        return result;
        //return board;
    }

    void dfs(int row) {
        if (row == n) {
            //不能是ans.add(p);
            ans.add(new ArrayList<>(p));
            return;
        }

        for (int col=0; col<n; col++) {
            if(!used[col] && !usedPlus.getOrDefault(row+col, false) && !usedMinus.getOrDefault(row-col, false)) {
                p.add(col);
                used[col] = true;
                usedPlus.put(row + col, true);
                usedMinus.put(row - col, true);
                dfs(row + 1);
                used[col] = false;
                usedPlus.remove(row + col);
                usedMinus.remove(row - col);
                p.remove(p.size()-1);
            }
        }


    }



}

class SolutionP51 {
    public static void main(String[] args) {
        P51NQueens p = new P51NQueens();
        p.solveNQueens(4);
    }
}


/*
51. N 皇后
n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。

每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。



示例 1：


输入：n = 4
输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
解释：如上图所示，4 皇后问题存在两个不同的解法。
示例 2：

输入：n = 1
输出：[["Q"]]

 */
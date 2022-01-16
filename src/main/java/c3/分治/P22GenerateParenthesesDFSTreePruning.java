package c3.分治;

import java.util.ArrayList;
import java.util.List;


/*
分治
前一段怎么分，后一段怎么分
一类无法切左右，
((()))
(()())
另一类可以分两段
(())()
()(())
还可以分三段
()()()

__ | ____  ()(()), ()()(),
____ | __  (())(), ()()()
找到第一个不可划分的整体A
S (A)B
s=n对括号
A=k-1对括号
B=n-k对括号

n=3
k=1, A=null, B=n-1=3-1=2对括号 B=()(),(())
k=2, A=(),)( B=(),
k=3, A=(()),()(), B=null

 */
public class P22GenerateParenthesesDFSTreePruning {

    List<String> ans = new ArrayList<>();
    int n;
    String s;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs(0, 0,0);
        return ans;
    }

    public void dfs(int i, int left, int right) {
        if (left >n || right >n || !isValid(s)) return;
        if (i == 2 * n) {
            if (isValid(s)) ans.add(s);
            return;
        }
        if (s == null || s.isEmpty())
            s = "(";
        else
            s = s + "(";

        dfs(i + 1, left+1, right);

        //remove last ch
        s = s.substring(0, s.length() - 1);
        if (s == null || s.isEmpty())
            s = ")";
        else
            s = s + ")";
        dfs(i + 1, left, right+1);
        s = s.substring(0, s.length() - 1);
    }

    boolean isValid(String s) {
        int left = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') left++;
            else {
                if (left <= 0) return false;
                left--;
            }
        }

        return true;
    }


}

class SolutionP22DFSTP {
    public static void main(String[] args) {
        P22GenerateParenthesesDFS p = new P22GenerateParenthesesDFS();
        p.generateParenthesis(3);
    }
}

/*
22. 括号生成
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。



示例 1：

输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
示例 2：

输入：n = 1
输出：["()"]


提示：

1 <= n <= 8
 */
package c3.分治;

import java.util.ArrayList;
import java.util.HashMap;
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
public class P22GenerateParentheses {

    HashMap<Integer, List<String>> cacheMap = new HashMap<>();


    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n==0) ans.add("");
        if (cacheMap.containsKey(n)) return cacheMap.get(n);
        else {
            //s=(A)B
            for (int k = 1; k <= n; k++) { //k是加法原理
                List<String> A = generateParenthesis(k - 1);
                List<String> B = generateParenthesis(n - k);
                //乘法原理,A有x种，B有y种，合起来x*y种
                for (String a : A)
                    for (String b : B)
                        ans.add("(" + a + ")" + b);
            }
        }
        cacheMap.put(n, ans);
        return ans;

    }

}

class SolutionP22 {
    public static void main(String[] args) {
        P22GenerateParentheses p = new P22GenerateParentheses();
        List<String> s = p.generateParenthesis(3);
        System.out.println(s);

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
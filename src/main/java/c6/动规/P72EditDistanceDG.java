package c6.动规;

/*
f[i,j]表示word1[1..i]与word2[1..j]的编辑距离
f[i,j] = min(插入f[i,j-1]+1,删除f[i-1,j]+1，替换或者不变f[i-1][j-1]+eq )
如果word1[i]=word2[j],eq=0，否则eq=1
插入
ea
ebc
先把ea=eb，f[i,j-1]
删除
hor
ro
先把ho=ro，f[i-1,j]
替换或不变
ac
ab
初值f[i,0]=i, f[0,j]=j
目标f[n,m]
 */
public class P72EditDistanceDG {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int eq;
        word1 = " " + word1;
        word2 = " " + word2;
        int[][] f = new int[m+1][n+1];
        for (int i=1;i<m;i++)
            for (int j=1;j<n;j++) {
                f[i][j] = -999999;
            }

        for (int i=0;i<m+1;i++) f[i][0] = i;
        for (int j=0;j<n+1;j++) f[0][j] = j;

        for(int i=1; i<m+1; i++)
            for (int j=1;j<n+1;j++) {
                if (word1.charAt(i) == word2.charAt(j))
                    eq=0;
                else
                    eq=1;
                f[i][j]= Math.min( Math.min(f[i][j-1]+1, f[i-1][j]+1), f[i-1][j-1] + eq);
            }

        return f[m][n];
    }
}
/*

72. 编辑距离
给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符


示例 1：

输入：word1 = "horse", word2 = "ros"
输出：3
解释：
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')
示例 2：

输入：word1 = "intention", word2 = "execution"
输出：5
解释：
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')
 */
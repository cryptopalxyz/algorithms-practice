package c7.并查集;

/*

小技巧：
用一个外界无限大区域，造一个特殊的点O，可以把图上边界的O连接成一个集合
矩阵用方向数组

 */
public class P130surroundedArea {
    int[] fa;
    public void solve(char[][] board) {
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        int m = board.length;
        int n = board[0].length;
        int outside = m*n;//外部无限大的特殊点
        //MakeSets
        fa = new int[m*n+1];
        for (int i=0; i<=m*n;i++) fa[i] = i;
        //i,j
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++) {
                if (board[i][j] == 'X') continue;
                for (int k=0; k<4; k++) {// k是4个方向
                    int ni = i + dx[k];
                    int nj = j + dy[k];
                    //出界了，要跟外部无限大相连
                    if (ni< 0 || nj <0 || ni>=m || nj >=n)
                        unionSet(num(i,j,n), outside);
                    else {
                        if (board[ni][nj] == 'O')
                            unionSet(num(i,j, n), num(ni, nj, n) );
                    }
                }
            }
        //跟外界相连的就不变
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++) {
                if (board[i][j] == 'O' && find(num(i,j,n)) != find(outside))
                    board[i][j] = 'X';
            }

    }

    //二维变成一维
    int num(int i, int j, int n) {
        return i * n + j;
    }


    public void unionSet(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) fa[x] = y;
    }

    //找到根
    public int find(int x) {
        if (x == fa[x]) return x;
        return fa[x] = find(fa[x]);//和find(fa[x])的区别是压缩路径
    }
}

class SolutionP130 {
    public static void main(String[] args) {
        P130surroundedArea p = new P130surroundedArea();
        char[][] board = {{'X','O','X','X'},{'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'}};
        p.solve(board);
    }


}
/*
130. 被围绕的区域
给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。


示例 1：


输入：board = [['X','X','X','X'],['X','O','O','X'],['X','X','O','X'],['X','O','X','X']]
输出：[['X','X','X','X'],['X','X','X','X'],['X','X','X','X'],['X','O','X','X']]
解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
示例 2：

输入：board = [['X']]
输出：[['X']]

 */
package c4.BFS;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*

时间复杂度O(M*N)
 */
public class P200NumberOfIslands {

    int m, n;

    //判重
    boolean[][] visited;




    public int numIslands(char[][] grid) {
        //把类的成员变量赋值
        this.m = grid.length;
        this.n = grid[0].length;
        int ans = 0;
        visited = new boolean[m][n];

        for (boolean[] v:visited)
            Arrays.fill(v, false);


        for (int i =0;i<m; i++)
            for (int j=0;j<n;j++)
                if (grid[i][j]== '1' && !visited[i][j]) {
                    ans++;
                    //进入bfs几次，就是几个岛屿，每次都会bfs完全部1
                    bfs(i,j,grid);
                }

        return ans;
    }

    void bfs(int sx, int sy, char[][] grid) {
        Deque<Pair<Integer, Integer>> q = new LinkedList<>();
        //方向数组
        int[] dx = {-1,0,0,1};
        int[] dy = {0,-1,1,0};
        q.push(new Pair<>(sx, sy));
        visited[sx][sy] = true;
        while (!q.isEmpty()) {
            // 第一步：取队头
            int x = q.getFirst().getKey();
            int y = q.getFirst().getValue();
            q.pop();
            // 第二步：扩展队头
            for (int i=0; i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                //出界
                if (nx <0 || nx>=m ||ny<0 || ny>=n) continue;
                //不为1
                if (grid[nx][ny] != '1') continue;
                //走过
                if (visited[nx][ny]) continue;
                q.push(new Pair<>(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }
}

class SolutionP200 {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        P200NumberOfIslands p = new P200NumberOfIslands();
        p.numIslands(grid);
    }
}
/*
200. 岛屿数量
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。



示例 1：

输入：grid = [
  ['1','1','1','1','0'],
  ['1','1','0','1','0'],
  ['1','1','0','0','0'],
  ['0','0','0','0','0']
]
输出：1
示例 2：

输入：grid = [
  ['1','1','0','0','0'],
  ['1','1','0','0','0'],
  ['0','0','1','0','0'],
  ['0','0','0','1','1']
]
输出：3
 */

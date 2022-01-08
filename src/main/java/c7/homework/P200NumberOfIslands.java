package c7.homework;

import java.util.HashSet;
import java.util.Set;

public class P200NumberOfIslands {
    int[] fa;

    public int numIslands(char[][] grid) {

        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        int m = grid.length;
        int n = grid[0].length;

        //MakeSets
        fa = new int[m * n];
        for (int i = 0; i < m * n; i++) fa[i] = i;
        //i,j
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                for (int k = 0; k < 4; k++) {// k是4个方向
                    int ni = i + dx[k];
                    int nj = j + dy[k];
                    //出界了，就不要
                    if (ni < 0 || nj < 0 || ni >= m || nj >= n)
                        continue;
                    else {
                        if (grid[ni][nj] == '1')
                            unionSet(num(i, j, n), num(ni, nj, n));
                    }
                }
            }


        Set<Integer> s = new HashSet<>();

        for (int i=0;i<m;i++)
            for(int j=0;j<n;j++) {
                if (grid[i][j] == '1')
                    s.add(find(num(i, j,n)));
            }

        return s.size();


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

class SolutionP200BCJ {
    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        grid = new char[][]{{'1'}};
       // grid = new char[][] {{'0','0','0','0','0','0','0'}};
        P200NumberOfIslands p = new P200NumberOfIslands();
        p.numIslands(grid);
    }

}


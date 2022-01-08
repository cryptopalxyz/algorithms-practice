package c7.字典树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import c7.字典树.P208ImplementingTrieHashMap.*;

/*

下面代码不对

 */
public class P212WordSearch {

    int [] dx = {-1, 0, 0, 1};
    int [] dy = {0, -1, 1, 0};
    NodeTrie root;
    int m, n;
    boolean[][] visit;
    List<String> ans = new ArrayList<>();
    String str;
    StringBuilder sb = new StringBuilder();
    //dfs深度优先
    //广度不行，访问过的就不能访问了，oa, oe,e访问过了不能达成oate
    public List<String> findWords(char[][] board, String[] words) {
        //跳过一些路线，比如oa前缀
        //把words存到字典树，格子/搜索走一步，字典树走一步

        //1.建立Trie，插入words
        root = new NodeTrie();
        for (String word : words)
            insert(word);
        //2.dfs,枚举每个起点，搜索
        m = board.length;
        n = board[0].length;
        visit = new boolean[m][];
        Arrays.fill(visit, false);
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                visit[i][j] = true;
                dfs(board, i, j, root);
                visit[i][j] = false;

            }

        return new ArrayList<>();
    }


    void insert(String s) {
        NodeTrie curr = root;
        for (char c: s.toCharArray()) {
            if (!curr.child.containsKey(c)) {
                curr.child.put(c, new NodeTrie());
            }
            curr = curr.child.get(c);
        }
        curr.count++;
    }

    void dfs(char[][]board, int x, int y, NodeTrie curr) {
        char ch = board[x][y];
        if (curr.child.containsKey(ch)) return;
        NodeTrie next = curr.child.get(ch);
        sb.append(ch);
        if (next.count > 0 ) ans.add(sb.toString());
        sb = new StringBuilder();
        //枚举分枝
        for (int i=0; i< 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx <0 || ny <0 || nx >=m || ny >=n) continue;
            if (visit[nx][ny]) continue;
            visit[nx][ny] = true;
            dfs(board, nx, ny, next);
            visit[nx][ny] = false;
        }
    }
}


/*
212. 单词搜索 II
给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。

单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。



示例 1：


输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
输出：["eat","oath"]
示例 2：


输入：board = [["a","b"],["c","d"]], words = ["abcb"]
输出：[]
 */

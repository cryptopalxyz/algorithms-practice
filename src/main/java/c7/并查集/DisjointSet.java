package c7.并查集;

public class DisjointSet {
    public DisjointSet(int n) {
        fa = new int[n];
        for (int i = 0; i < n; i++)
            fa[i] = i;
    }

    //找到根
    public int find(int x) {
        if (x == fa[x]) return x;
        return fa[x] = find(fa[x]);//和find(fa[x])的区别是压缩路径
    }

    public void unionSet(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) fa[x] = y;
    }

    int[] fa;
};
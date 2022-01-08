package c7.homework;

public class P684RedundentConnection {

    int[] fa;

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        //MakeSets
        fa = new int[n+1];
        for (int i = 1; i < n+1; i++) fa[i] = i;

        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (find(node1) != find(node2)) {
                unionSet(node1, node2);
            } else {
                return edge;//两条边的终点相同，直接返回，题目要求只有一条这样的边
            }
        }
        return new int[0];


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

class SolutionP684BCJ {
    public static void main(String[] args) {
        int[][] edges ={{1,2}, {1,3}, {2,3}};
        P684RedundentConnection p = new P684RedundentConnection();
        p.findRedundantConnection(edges);
    }
}
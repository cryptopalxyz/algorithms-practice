package c3.图;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/*
O(n*n)
 */
public class P684RedundantConnection {

    ArrayList<ArrayList<Integer>> to;

    //用来判断是否访问过
    //ArrayList<Boolean> visited;
    boolean[] visited;
    boolean hasCycle = false;
    int n = 0;

    public int[] findRedundantConnection(int[][] edges) {
        //求最大的n
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            n = Math.max(n, Math.max(x, y));
        }


        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++)
            visited[i] = false;
        //因为0不用，所以n+1
        to = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            to.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            //把下标对应的数组加元素
            // 无向图看作双向边的有向图
            to.get(x).add(y);
            to.get(y).add(x);
            //每次加完边就dfs，当hasCycle变成true 就返回
            //-1表示fasther不存在
            for (int i = 0; i <= n; i++) visited[i] = false;
            dfs(x, -1);
            if (hasCycle)
                return edge;
        }
        return new int[]{};
    }

    //father-x-y
    //深度优先遍历，找环
    void dfs(int x, int father) {
        visited[x] = true;
        //出边数组访问点x能到的周围点的方法
        for (int y : to.get(x)) {
            if (y == father) continue;
            //环
            if (visited[y]) hasCycle = true;
            else
                dfs(y, x);
        }


    }


}

class SolutionP684 {
    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        P684RedundantConnection p = new P684RedundantConnection();
        p.findRedundantConnection(edges);


    }
}
/*
树可以看成是一个连通且 无环 的 无向 图。

给定往一棵 n 个节点 (节点值 1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n 中间，且这条附加的边不属于树中已存在的边。图的信息记录于长度为 n 的二维数组 edges ，edges[i] = [ai, bi] 表示图中在 ai 和 bi 之间存在一条边。

请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组 edges 中最后出现的边。

 

示例 1：



输入: edges = [[1,2], [1,3], [2,3]]
输出: [2,3]
示例 2：



输入: edges = [[1,2], [2,3], [3,4], [1,4], [1,5]]
输出: [1,4]
 

提示:

n == edges.length
3 <= n <= 1000
edges[i].length == 2
1 <= ai < bi <= edges.length
ai != bi
edges 中无重复元素
给定的图是连通的 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/redundant-connection
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
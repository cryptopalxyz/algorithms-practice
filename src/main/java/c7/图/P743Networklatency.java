package c7.图;

import java.util.Arrays;

public class P743Networklatency {
    int INF = (int)1e9;

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        dist[k] = 0;
        for (int round=1; round< n; round++) {
            for (int[] edge: times) {
                int x = edge[0];
                int y = edge[1];
                int z = edge[2];
                if (dist[y] > dist[x] + z)
                    dist[y] = dist[x] + z;
            }
        }
        int ans = 0;
        for (int i=1; i< n+1; i++)
            ans = Math.max(ans, dist[i]);
        return ans == INF? -1 :ans;

    }
}

/*
743. 网络延迟时间
有 n 个网络节点，标记为 1 到 n。

给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。

现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。



示例 1：



输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
输出：2
示例 2：

输入：times = [[1,2,1]], n = 2, k = 1
输出：1
 */
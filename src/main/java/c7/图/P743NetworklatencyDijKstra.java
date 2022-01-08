package c7.图;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class P743NetworklatencyDijKstra {


    public int networkDelayTime(int[][] times, int n, int k) {

        //if (times.length == 1) return 0;

        int INF = (int) 1e9 - 1;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        //int[][] ver = new int[n+1][];
        //int[][] edge = new int[n+1][]; //边权
        List<ArrayList<Integer>> ver = new ArrayList<>();
        List<ArrayList<Integer>> edge = new ArrayList<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> {return a[0] - b[0];});



        //该节点是否扩展过
        boolean[] expand = new boolean[n + 1];

        //初始化
        for (int i = 0; i <= n; i++) {
            ver.add(new ArrayList<Integer>());
            edge.add(new ArrayList<Integer>());
            expand[i] = false;
            dist[i] = INF;
        }

        //建图，存在出边数组
        for (int[] t : times) {
            int x = t[0];
            int y = t[1];
            int z = t[2];
            ver.get(x).add(y);
            //ver.get(y).add(x);
            edge.get(x).add(z);
            //edge.get(y).add(z);

        }


        //距离是0的编号是K的点
        q.offer(new int[] {0,k});

        //初始化
        dist[k] = 0;

        while(!q.isEmpty()) {
            int[] top = q.poll();
            int x = top[1];
            if (expand[x]) continue;
            expand[x] = true;
            for (int i=0;i<ver.get(x).size(); i++) {
                int y = ver.get(x).get(i);
                int z = edge.get(x).get(i);
                if (dist[y] > dist[x] + z) {
                    dist[y] = dist[x] + z;
                    q.offer(new int[] {dist[y], y});
                }
            }
        }
        int ans = 0;
        for (int i=1; i<=n; i++) ans = Math.max(ans, dist[i]);
        return ans == INF ? -1:ans;
    }
}

class SolutionP743D {
    public static void main(String[] args) {
        P743NetworklatencyDijKstra p = new P743NetworklatencyDijKstra();
        //int[][] x = {{2,1,1},{2,3,1},{3,4,1}};
        //p.networkDelayTime(x,4,2);
        int[][]x = {{1,2,1}};
        p.networkDelayTime(x, 2,2);
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
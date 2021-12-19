package c5.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
批处理，按照差分
1-3加1
2-6加1
哪些数大于0，就返回

差分left +1，right的下一个-1
1： + 1
4： -1

2： +1
7： -1

8: +1
11: -1

15: +1
19: -1

排序
1： + 1
2： +1
4： -1


7： -1

8: +1
11: -1

15: +1
19: -1
计数器从0变1表示区间开始
从1变0表示区间结束

 */
/*

[[1,4],[5,6]]
不能合并成[1,6] 所以这种方法不行
跳过解法二

 */
public class P56MergeIntervalsAgain {
    public int[][] merge(int[][] intervals) {
        int max = -1;
        for (int [] interval: intervals)
            max = Math.max(max, interval[1]);
        int[] p = new int[max + 1];
        Arrays.fill(p, 0);
        for (int [] interval: intervals) {
            int left = interval[0];
            int right = interval[1];
            for (int i=left; i<=right; i++)
                p[i] = 1;
        }

        int start = -1;
        int end = -1;
        boolean intervalFlag = false; //开始了一段interval
        ArrayList<int []> ans = new ArrayList<>();

        for (int i=0; i<p.length; i++) {
            //开始一段新的
            if (p[i] == 0 || i == p.length -1 ) {
                if (start != -1 && end != -1) {
                    if (p[i] == 1 ) {
                        //特殊情况，最后一个是1
                        ans.add(new int[]{start, p.length - 1});
                        start = -1;
                        end = -1;
                        continue;
                    }
                    ans.add(new int[]{start, end});
                    start = -1;
                    end = -1;
                }

            }
            else {
                if (start == -1)
                    start = i;
                else
                    end = i;
                }
            }

        int[][]result = new int[ans.size()][];
        for (int i=0;i<ans.size(); i++)
            result[i] = ans.get(i);

        return result;
    }
}

class SolutionP56Again {
    public static void main(String[] args) {
        P56MergeIntervalsAgain p = new P56MergeIntervalsAgain();
        //int[] [] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[] [] intervals = {{1,4},{5,6}};
        p.merge(intervals);
    }
}

/*
56. 合并区间
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。



示例 1：

输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2：

输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。




 */

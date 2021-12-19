package c5.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P56MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //前面相等，排第二个数
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                else
                return o1[0] - o2[0];
            }
        });
        List<int[]> ans  = new ArrayList<>();
//{1,3},{2,6},{8,10},{15,18}
        int farthest = -1;//当前右边最远
        int start = -1;
        for (int[] interval: intervals ) {
            int left = interval[0];
            int right = interval[1];
            if (left <= farthest) {
                //新的interval的左边比前面的右边小，说明被前面包含，不需要增加元素，只需要把右边的数设为最大值
                farthest = Math.max(farthest, right);
            }else {
                //不在区间内，新的元素
                if (farthest != -1) {//第一组不加
                    ans.add(new int[] {start, farthest});
                }
                //前一组的左，右值
                start = left;
                farthest = right;
            }
        }

        ans.add(new int[] {start, farthest});

        int[] [] result = new int [ans.size()][];
        for (int i=0; i<ans.size(); i++)
            result[i] = ans.get(i);

        return result;
    }
}

class SolutionP56 {
    public static void main(String[] args) {
        P56MergeIntervals p = new P56MergeIntervals();
        int[] [] intervals = {{1,3},{2,6},{8,10},{15,18}};
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

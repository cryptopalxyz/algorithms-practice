package c5.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class P1122RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<arr2.length; i++)
            map.put(arr2[i], i); //arr2中没有重复数据

        for(int num : arr1)
            list.add(num);

        Collections.sort(list, (x, y) -> {
            //arr2中，就按照arr2的下标排序
            if(map.containsKey(x) || map.containsKey(y)) return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
            //不在arr2中，就按照大小排序
            return x - y;
        });
        int[] ans = new int[list.size()];
        for (int i=0; i<list.size(); i++)
            ans[i] = list.get(i);

        return ans;
    }
}

class SolutionP1122 {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19}, arr2 = {2,1,4,3,9,6};
        P1122RelativeSortArray p = new P1122RelativeSortArray();
        p.relativeSortArray(arr1, arr2);
    }
}

/*
1122. 数组的相对排序
给你两个数组，arr1 和 arr2，

arr2 中的元素各不相同
arr2 中的每个元素都出现在 arr1 中
对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。



示例：

输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
输出：[2,2,2,1,4,3,3,9,6,7,19]


提示：

1 <= arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
arr2 中的元素 arr2[i] 各不相同
arr2 中的每个元素 arr2[i] 都出现在 arr1 中

 */
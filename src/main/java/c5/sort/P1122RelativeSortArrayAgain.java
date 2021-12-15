package c5.sort;

import java.util.*;

/*
不比较的方法,计数排序
 */
public class P1122RelativeSortArrayAgain {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();

        int[] count = new int[1001];
        Arrays.fill(count, 0);
        for (int val: arr1)
            count[val] ++ ;

        for (int val: arr2) {
            while (count[val]>0) {
                list.add(val);
                count[val]-- ;
            }
        }
        //不再arr2里面的
        for (int val=0; val<= 1000; val++) {
            while (count[val]>0) {
                list.add(val);
                count[val]-- ;
            }
        }

        int[] ans = new int[list.size()];
        for (int i=0; i<list.size(); i++)
            ans[i] = list.get(i);

        return ans;
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
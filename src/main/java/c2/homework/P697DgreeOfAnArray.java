package c2.homework;

import java.util.HashMap;

/*

记原数组中出现次数最多的数为 xx，那么和原数组的度相同的最短连续子数组，必然包含了原数组中的全部 xx，且两端恰为 xx 第一次出现和最后一次出现的位置。

我们使用哈希表实现该功能，每一个数映射到一个长度为 33 的数组，数组中的三个元素分别代表这个数出现的次数、这个数在原数组中第一次出现的位置和这个数在原数组中最后一次出现的位置。
int[] 0=次数，1=第一个下标，2=最后一个下标
 */
public class P697DgreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        //1. 存所有数字的出现的总次数，第一个下标和最后一个下标
        HashMap<Integer, int[]> map = new HashMap<>();
        int n = nums.length;
        for (int i=0; i<n; i++) {
            if (map.containsKey(nums[i]))
                map.put(nums[i], new int[] {map.get(nums[i])[0]+1, map.get(nums[i])[1], i});
            else
                map.put(nums[i], new int[] {1, i, i});
        }


        //2. 循环map找出max
        int max = 0;
        int minLen = 50000;
        for (Integer key: map.keySet()) {
            max = Math.max(max, map.get(key)[0]);
        }

        //比较最小的length
        for (Integer key: map.keySet()) {
            if (max == map.get(key)[0])  {
                int currentMinLen = map.get(key)[2] - map.get(key)[1] + 1;
                minLen = Math.min(currentMinLen, minLen);
            }

        }


        return minLen;

    }
}

class SolutionP697 {
    public static void main(String[] args) {
        int[] nums = {1,3,2,2,3,1};
        P697DgreeOfAnArray p697DgreeOfAnArray = new P697DgreeOfAnArray();
        p697DgreeOfAnArray.findShortestSubArray(nums);
    }
}

/*
给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。

你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。

 

示例 1：

输入：[1, 2, 2, 3, 1]
输出：2
解释：
输入数组的度是2，因为元素1和2的出现频数最大，均为2.
连续子数组里面拥有相同度的有如下所示:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
最短连续子数组[2, 2]的长度为2，所以返回2.
示例 2：

输入：[1,2,2,3,1,4,2]
输出：6
 

提示：

nums.length 在1到 50,000 区间范围内。
nums[i] 是一个在 0 到 49,999 范围内的整数。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/degree-of-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
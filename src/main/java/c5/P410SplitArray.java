package c5;

/*
求解：最小化"m个子数组各自和的最大值"
判定：给一个数值T，"m个子数组各自和的最大值<=T"是否成立
或者："能否讲nums分成m个连续子数组，每组的和<=T"
 */
public class P410SplitArray {
    public int splitArray(int[] nums, int m) {
        int left = 0;
        int right = 0;
        //计算边界
        for (int num:nums) {
            left = Math.max(left, num);
            right += num;
        }
        while (left < right ) {
            int mid = (left + right)/2;
            if (validate(nums, m, mid)) {
                right = mid;
            }else
                left = mid + 1;
        }
        return right;
    }

    boolean validate (int[] nums, int m, int size) {
        int box = 0;  //盒子里面的和
        int count = 1;  //一个盒子
        for (int num : nums) {
            if (box + num <=size)
                box += num;
        else{
                count++;
                box = num;
            }
        }
        return count <=m;
    }
}


/*
410. 分割数组的最大值
给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。

设计一个算法使得这 m 个子数组各自和的最大值最小。



示例 1：

输入：nums = [7,2,5,10,8], m = 2
输出：18
解释：
一共有四种方法将 nums 分割为 2 个子数组。 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
示例 2：

输入：nums = [1,2,3,4,5], m = 2
输出：9
示例 3：

输入：nums = [1,4,4], m = 3
输出：4

 */
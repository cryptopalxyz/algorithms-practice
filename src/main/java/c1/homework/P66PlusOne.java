package c1.homework;

// 从后往前找第一个不是9的数字，加1，把找过的全部变成0
// 假如没找到9， 那么直接把最后一个数字加1
// 假如全是9，增加1位，
public class P66PlusOne {
    public int[] plusOne(int[] digits) {
        /*
        如果 digits 的末尾没有 9，例如 [1, 2, 3]那么我们直接将末尾的数加一，得到 [1, 2, 4]并返回；

        如果  digits 的末尾有若干个 9，例如 [1,2,3,9,9]，那么我们只需要找出从末尾开始的第一个不为 9 的元素，即 3，将该元素加一，得到 [1, 2, 4, 9, 9]。
        随后将末尾的 9 全部置零，得到 [1, 2, 4, 0, 0]  并返回

        下面的逻辑是从后往前，如果是9，则continue继续往前，
        直到找到第一个不为9的数字，加1，同时要把跳过的9变成0，99变成00，999变成000
         */
        for (int i=digits.length -1 ; i>=0 ;i--) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                //后面变成0
                for (int j=i+1;j<digits.length;j++)
                    digits[j] = 0;
                return digits;
            }else
                continue;
        }

        //digits全是9
        int[] ans = new int[digits.length + 1];
        for (int i=1;i<ans.length;i++)
            ans[i] = 0;
        ans[0] = 1;
        return ans;
    }

}

class SolutionP66 {
    public static void main(String[] args) {
        P66PlusOne p = new P66PlusOne();
        int [] nums = {1,2,9};
        p.plusOne(nums);
    }
}



/*
给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

 

示例 1：

输入：digits = [1,2,3]
输出：[1,2,4]
解释：输入数组表示数字 123。
示例 2：

输入：digits = [4,3,2,1]
输出：[4,3,2,2]
解释：输入数组表示数字 4321。
示例 3：

输入：digits = [0]
输出：[1]
 

提示：

1 <= digits.length <= 100
0 <= digits[i] <= 9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/plus-one
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
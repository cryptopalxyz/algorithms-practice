package c3.分治;

public class P50PowXN {
    public double myPow(double x, int n) {
        if (n==0) return 1;
        //为了处理越界, 负的出界了,2(31）次方
        if (n == - (1l<< 31)) return 1.0 / (myPow(x, -(n+1)) * x);
        if (n<0) return 1.0/myPow(x, -n);
        double temp = myPow(x, n/2);
        double ans = temp * temp;
        if (n%2 == 1) ans = ans * x;
        return ans;
    }
}

/*
实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。

 

示例 1：

输入：x = 2.00000, n = 10
输出：1024.00000
示例 2：

输入：x = 2.10000, n = 3
输出：9.26100
示例 3：

输入：x = 2.00000, n = -2
输出：0.25000
解释：2-2 = 1/22 = 1/4 = 0.25

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/powx-n
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
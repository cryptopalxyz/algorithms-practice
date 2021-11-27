package c2.差分;


/*
暴力解法：
n*m
差分
n+m



 */
public class P109CorporateFlightBooking {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] delta = new int[n + 2]; //对n+1有操作，0～n+1
        //初始化delta 差分数组
        for (int i = 0; i < delta.length; i++)
            delta[i] = 0;
        for (int[] booking : bookings) {
            int first = booking[0];
            int last = booking[1];
            int seats = booking[2];
            //对差分数组做操作
            delta[first] += seats;
            delta[last + 1] -= seats;

        }
        int[] sum = new int[n + 1];
        sum[0] = 0;
        //初始化前缀和数组
        for (int i = 1; i < sum.length; i++)
            sum[i] = sum[i - 1] + delta[i];

        //去掉前面的0，s[0]
        int[] ans = new int[sum.length - 1];
        for (int i = 0; i < ans.length; i++)
            ans[i] = sum[i + 1];
        return ans;
    }
}


/*
这里有 n 个航班，它们分别从 1 到 n 进行编号。

有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。

请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。

 

1   2    3    4    5
10      -10
   20         -20
   25                  -25(越界变00)
10 45  -10   -20   0
10 55   45    25   0  （前缀和）
示例 1：

输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
输出：[10,55,45,25,25]
解释：
航班编号        1   2   3   4   5
预订记录 1 ：   10  10
预订记录 2 ：       20  20
预订记录 3 ：       25  25  25  25
总座位数：      10  55  45  25  25
因此，answer = [10,55,45,25,25]
示例 2：

输入：bookings = [[1,2,10],[2,2,15]], n = 2
输出：[10,25]
解释：
航班编号        1   2
预订记录 1 ：   10  10
预订记录 2 ：       15
总座位数：      10  25
因此，answer = [10,25]
 

提示：

1 <= n <= 2 * 104
1 <= bookings.length <= 2 * 104
bookings[i].length == 3
1 <= firsti <= lasti <= n
1 <= seatsi <= 104


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/corporate-flight-bookings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


 */

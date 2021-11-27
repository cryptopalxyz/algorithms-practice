package c2.哈希;

import java.util.HashSet;
import java.util.Set;

/*


 */
public class P874WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        //x"_"y作为元素，string类型
        //set.contains 是O(1)找到元素
        Set<String> set = new HashSet<>();
        for (int[] obstacle : obstacles)
            set.add(calcHash(obstacle));
        int x = 0, y = 0;
        int dir = 0;//north=0,east=1,south=2,west=3//往右转(dir+1) mod 4, 往左转(dir-1+4)mod4
        //网格中行走，技巧：方向数组，
        //北向每走一步x y变化量，向东，向南，向西
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int ans = 0;

        for (int command : commands) {
            if (command == -1)
                dir = (dir + 1) % 4;
            else if (command == -2)
                dir = (dir + 3) % 4;
            else {
                for (int i = 0; i < command; i++) {
                    //下一个x，y的点
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if (set.contains(calcHash(new int[]{nx, ny}))) {
                        break;//是障碍物
                    } else {
                        x = nx;
                        y = ny;
                        ans = Math.max(ans, x * x + y * y);
                    }
                }
            }

        }
        return ans;
    }

    String calcHash(int[] obstacle) {
        return String.valueOf(obstacle[0]) + "_" + String.valueOf(obstacle[1]);

    }
}

class SolutionP874 {
    public static void main(String[] args) {
        P874WalkingRobotSimulation p = new P874WalkingRobotSimulation();
        int[] nums = {4, -1, 3};
        int[][] ob = {};
        p.robotSim(nums, ob);
    }
}

/*
机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：

-2 ：向左转 90 度
-1 ：向右转 90 度
1 <= x <= 9 ：向前移动 x 个单位长度
在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点  obstacles[i] = (xi, yi) 。

机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。

返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ）

 
注意：

北表示 +Y 方向。
东表示 +X 方向。
南表示 -Y 方向。
西表示 -X 方向。
 

示例 1：

输入：commands = [4,-1,3], obstacles = []
输出：25
解释：
机器人开始位于 (0, 0)：
1. 向北移动 4 个单位，到达 (0, 4)
2. 右转
3. 向东移动 3 个单位，到达 (3, 4)
距离原点最远的是 (3, 4) ，距离为 32 + 42 = 25
示例 2：

输入：commands = [4,-1,4,-2,4], obstacles = [[2,4]]
输出：65
解释：机器人开始位于 (0, 0)：
1. 向北移动 4 个单位，到达 (0, 4)
2. 右转
3. 向东移动 1 个单位，然后被位于 (2, 4) 的障碍物阻挡，机器人停在 (1, 4)
4. 左转
5. 向北走 4 个单位，到达 (1, 8)
距离原点最远的是 (1, 8) ，距离为 12 + 82 = 65

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/walking-robot-simulation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
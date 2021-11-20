package c1.stack;

import java.util.*;

//要检查上一个op的优先级跟当前的op是否一致，上一个低就算当前op，上一个相同或低不然算上一个op
//用2个栈，一个栈存运算符，把优先级高的op放在栈顶
//当新的op1入栈，比较op1与栈里的op2优先级，如果op2里高，op2出栈算，如果低，op1入栈
/*
3+2*2
op stack: + *
num stack: 3 2 2
//或者生成tokens，然后用后缀表达式来计算。


 */
public class P227BasicCalculatorTwo {
    public int calculate(String s) {
        Deque<Character> opStack = new LinkedList<>();
        Deque<Integer> numStack = new LinkedList<>();

        String number = "";
        for (int i=0; i<s.length();i++) {
            Character ch= s.charAt(i);
            //可能是连续的数字 比如100
            if (Character.isDigit(ch) ){
                number+=ch;
                if (i == s.length() - 1) {
                    numStack.push(Integer.valueOf(number));
                    break;
                }
                else
                    continue;
            } else {
                if (!number.isEmpty()) {
                    numStack.push(Integer.valueOf(number));
                    number = "";
                }

            }
            if (ch ==' ') continue;
            //now ch is op
            int currRank = getRank(ch);
            //栈里面的优先级高
            //shall be while
            while (!opStack.isEmpty() && getRank(opStack.peek()) >= currRank ) {
                Integer int1 = numStack.pop();
                Integer int2 = numStack.pop();
                numStack.push(cal(int2, int1, opStack.pop()));
                //opStack.push(ch);

            }
            //栈里面的优先级低
            opStack.push(ch);

        }

        while (!opStack.isEmpty()) {
            Integer int1 = numStack.pop();
            Integer int2 = numStack.pop();
            numStack.push(cal(int2, int1, opStack.pop()));
        }

        return numStack.pop();

    }

    int getRank(Character op) {
        if (op == '*' || op == '/') return 2;
        else return 1;

    }

    int cal(int i, int j, Character op) {
        if (op == '+')
            return i + j;
        else if (op == '-')
            return i - j;
        else if (op == '*')
            return i * j;
        else if (op == '/')
            return i / j;
        else
            return 0;

    }
}

class SolutionP227BasicCalculatorTwo {
    public static void main(String[] args) {
        String s = "3+2*2";
        P227BasicCalculatorTwo p227BasicCalculatorTwo = new P227BasicCalculatorTwo();
        p227BasicCalculatorTwo.calculate(s);

    }
}

/*


nums: 1 2
op:   *
ch: -

nums: 2
op:   -

nums: 2 3
op:   -
ch: /

nums: 2 3
op:   - /

nums: 2 3 4
op:   - /
ch: +

nums: 2 0
op:   -
ch: +

nums: 2 0
op:   -
 +



给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。

整数除法仅保留整数部分。

 

示例 1：

输入：s = "3+2*2"
输出：7
示例 2：

输入：s = " 3/2 "
输出：1
示例 3：

输入：s = " 3+5 / 2 "
输出：5
 

提示：

1 <= s.length <= 3 * 105
s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
s 表示一个 有效表达式
表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
题目数据保证答案是一个 32-bit 整数

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/basic-calculator-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
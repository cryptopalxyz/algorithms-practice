package c1.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class P20ValidParentheses {
    public boolean isValid(String s) {
        //左括号就入栈，右括号就把栈顶的出栈

        Deque<Character> stack = new LinkedList<Character>();
        for (int i=0;i<s.length();i++) {
            Character ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{')
                stack.push(ch);
            else {
                if (stack.isEmpty()) return false;
                if ( (ch == ')') && (stack.peek() != '(')) return false;
                if ( (ch == ']') && (stack.peek() != '[')) return false;
                if ( (ch == '}') && (stack.peek() != '{')) return false;
                stack.pop();
            }

        }
        return stack.isEmpty();
    }
}

/*

给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
 

示例 1：

输入：s = "()"
输出：true
示例 2：

输入：s = "()[]{}"
输出：true
示例 3：

输入：s = "(]"
输出：false
示例 4：

输入：s = "([)]"
输出：false
示例 5：

输入：s = "{[]}"
输出：true
 

提示：

1 <= s.length <= 104
s 仅由括号 '()[]{}' 组成

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
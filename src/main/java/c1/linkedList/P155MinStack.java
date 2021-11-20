package c1.linkedList;

import java.util.Deque;
import java.util.LinkedList;

//最小栈
//使用额外的空间来保存最小元素
//用一个stack记录前缀最小值，stack随着MinStack pop，自己也pop
//-2  0 -3
//-2 -2 -3
public class P155MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public P155MinStack() {
        this.xStack = new LinkedList<Integer>();
        this.minStack = new LinkedList<Integer>();
    }

    public void push(int val) {
        xStack.push(val);
        if (minStack.isEmpty())
            minStack.push(val);
        else
            minStack.push(Math.min(minStack.peek() ,val));


    }

    public void pop() {
        xStack.pop();
        minStack.pop();

    }

    public int top() {
        return xStack.peek();

    }

    public int getMin() {
        return minStack.peek();
    }
}

/*

设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) —— 将元素 x 推入栈中。
pop() —— 删除栈顶的元素。
top() —— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。
 

示例:

输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

输出：
[null,null,null,null,-3,null,0,-2]

解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
 

提示：

pop、top 和 getMin 操作总是在 非空栈 上调用。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/min-stack
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
package c3.树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P589NaryTreePreOrderTraversalAgain {
    List<Integer> seq = new ArrayList<>();
    Stack<Node> stack = new Stack<>();
    public List<Integer> preorder(Node root) {
        seq = new ArrayList<>();
        if (root == null) return seq;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            seq.add(node.val);
            // 栈是先入后出，child 从右往左入栈
            for (int i=node.children.size() - 1;i>=0;i--  ) {
                stack.push(node.children.get(i));
            }

        }
        return seq;
    }


}

package c3.树;






import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class P102NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Pair<Node, Integer>> q = new LinkedList<Pair<Node, Integer>>();
        List<List<Integer>> seq = new ArrayList<List<Integer>>();
        if (root== null) return seq;
        q.add(new Pair<Node, Integer>(root, 0));//root, 层数0
        while (!q.isEmpty()) {
            Node node = q.peek().getKey();
            Integer depth = q.poll().getValue();
            //访问数组前先处理数组越界
            if (depth >= seq.size()) seq.add(new ArrayList<Integer>());
            seq.get(depth).add(node.val); //把数组的depth层加上该元素
            for (Node child: node.children) {
                //孩子的depth要+1
                q.add(new Pair<Node, Integer>(child, depth+1));
            }
        }
        return seq;
    }
}


/*

给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。

树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。

 

示例 1：



输入：root = [1,null,3,2,4,null,5,6]
输出：[[1],[3,2,4],[5,6]]
示例 2：



输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 

提示：

树的高度不会超过 1000
树的节点总数在 [0, 10^4] 之间

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */

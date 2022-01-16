package c3.树;

import c3.递归.TreeNode;

public class P111MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        //如果左孩子和右孩子有为空的情况，直接返回m1+m2+1
        if (root.left == null || root.right == null)
            return minDepth(root.left) + minDepth(root.right) + 1;
        //如果都不为空，返回较小深度+1
        return Math.min( minDepth(root.left), minDepth(root.right)) + 1;

    }

}

/*

           2
    null      3
          null  4
                  5
                    6



111. 二叉树的最小深度
给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明：叶子节点是指没有子节点的节点。



示例 1：


输入：root = [3,9,20,null,null,15,7]
输出：2
示例 2：

输入：root = [2,null,3,null,4,null,5,null,6]
输出：5


提示：

树中节点数的范围在 [0, 105] 内
-1000 <= Node.val <= 1000


 */

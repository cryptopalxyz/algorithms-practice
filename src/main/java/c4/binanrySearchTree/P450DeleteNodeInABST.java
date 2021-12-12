package c4.binanrySearchTree;

import c3.递归.TreeNode;

public class P450DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return  null;
        if (root.val == key ) {
            //如果val只有一棵子树，直接删除val，把子树和负节点相连就行了
            //如果有2颗子树，需要找到后继，先删除后继，再用后继节点代替val的位置
            //（因为后继是右子树一直往左走到底，最多有一颗子树）
            if (root.left == null ) return root.right;
            if (root.right == null) return root.left;
            //如果有2颗子树，需要找到后继，先删除后继，再用后继节点代替val的位置
            //（因为后继是右子树一直往左走到底，最多有一颗子树）
            TreeNode next = root.right;
            while (next.left != null) next = next.left;
            //先把后继删了
            root.right = deleteNode(root.right, next.val);
            root.val = next.val;

        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }else
            root.right = deleteNode(root.right, key);

        return root;
    }
}


/*
450. 删除二叉搜索树中的节点
给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。

一般来说，删除节点可分为两个步骤：

首先找到需要删除的节点；
如果找到了，删除它。


示例 1:



输入：root = [5,3,6,2,4,null,7], key = 3
输出：[5,4,6,2,null,null,7]
解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
另一个正确答案是 [5,2,6,null,4,null,7]。


示例 2:

输入: root = [5,3,6,2,4,null,7], key = 0
输出: [5,3,6,2,4,null,7]
解释: 二叉树不包含值为 0 的节点
示例 3:

输入: root = [], key = 0
输出: []



 */
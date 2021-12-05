package c3.树;

import apple.laf.JRSUIUtils;
import c3.递归.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P94BinaryTreeInorderTraversal {
    List<Integer> seq = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        dfs(root);
        return seq;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;;
        dfs(root.left);
        seq.add(root.val);
        dfs(root.right);
    }
}

/*
给定一个二叉树的根节点 root ，返回它的 中序 遍历。

 

示例 1：


输入：root = [1,null,2,3]
输出：[1,3,2]
示例 2：

输入：root = []
输出：[]
示例 3：

输入：root = [1]
输出：[1]


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


 */

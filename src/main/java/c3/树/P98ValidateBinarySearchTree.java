package c3.树;

import c3.递归.TreeNode;

public class P98ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        //此处可以看题目给出的范围，如果没给就用long
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }
    //需要额外2个参数，所以另些一个参数
    public boolean check(TreeNode root, long rangeLeft, long rangeRight) {
        if (root == null) return true;
        if (root.val <rangeLeft || root.val > rangeRight) return  false;
        return check(root.left, (long) rangeLeft, (long)root.val -1 )
        && check(root.right, (long) root.val +1, (long) rangeRight);

    }
}

/*

98. 验证二叉搜索树
给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

有效 二叉搜索树定义如下：

节点的左子树只包含 小于 当前节点的数。
节点的右子树只包含 大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。


示例 1：


输入：root = [2,1,3]
输出：true
示例 2：


输入：root = [5,1,4,null,null,3,6]
输出：false
解释：根节点的值是 5 ，但是右子节点的值是 4 。


提示：

树中节点数目范围在[1, 104] 内
-231 <= Node.val <= 231 - 1

 */
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

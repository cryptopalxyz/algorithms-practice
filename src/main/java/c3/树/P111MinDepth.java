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



 */

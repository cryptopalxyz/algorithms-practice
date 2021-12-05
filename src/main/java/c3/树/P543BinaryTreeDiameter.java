package c3.树;

import c3.递归.TreeNode;

/*
左子树深度+右子树深度 +1
要+1是因为左右孩子到自己要+1
 */
public class P543BinaryTreeDiameter {
    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        depth(root);
        return ans;

    }
    public int depth(TreeNode root) {
        if (root==null)
            return  0;
        int left = depth(root.left);
        int right = depth(root.right);
        ans = Math.max(left+ right, ans);
        return Math.max(left, right)+ 1;//左右孩子到根节点要+1

    }
}


/*
543. 二叉树的直径
给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。



示例 :
给定二叉树

          1
         / \
        2   3
       / \
      4   5
返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。



注意：两结点之间的路径长度是以它们之间边的数目表示。

 */
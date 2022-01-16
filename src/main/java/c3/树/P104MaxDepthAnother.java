package c3.树;

import c3.递归.TreeNode;


/*
还原现场
把深度作为一个全局变量，一个跟随节点移动而动态变化的信息
递归层+1，变量+1，在叶子处更新答案
 */
public class P104MaxDepthAnother {
    int depth;
    int ans = 0;
    public int maxDepth(TreeNode root) {
        ans = 0;
        depth = 1;
        calc(root);
        return ans;

    }

    void calc(TreeNode root) {
        if (root == null) return;
        ans = Math.max(ans, depth);
        depth++;
        calc(root.left);
        calc(root.right);
        //还原现场
        depth--;
    }
}
/*
104. 二叉树的最大深度
给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。


 */
package c3.树;

import c3.递归.TreeNode;

/*

l1=0,r1=4
l2=0,r2=4
preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
      3
  9      20

      15     7

l1=1,r1=1
l2=0,r2=0
preorder = [9] inorder = [9]
l1=2,r1=4
l1=2,r2=4
preorder = [20, 15, 7] inorder = [15, 20, 7]
l1=3,r1=3
l1=2,r2=2
preorder = [15] inorder = [15]
l1=4,r1=4
l1=4,r2=4
preorder = [20, 15, 7] inorder = [15, 20, 7]
 */
public class P105ConstrunctBinaryTreeFromPreorderAndInorderTraversal {
    int[] preorder;
    int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        //两个整段来还原一颗树
        return build(0, preorder.length -1, 0, inorder.length -1 );


    }
    //用preorder[l1..r1]和inorder[l2..r2]来还原二叉树
    //l1 ... r1是preoder的下标，l2 ... r2是inorder的下标
    //l1 ...  r1 子问题
    //l2 ...  r2 子问题
    TreeNode build(int l1, int r1, int l2, int r2 ) {
        //没点了
        if (l1>r1 || l2> r2) return null;
        TreeNode root = new TreeNode(preorder[l1]);
        //inorder中序求根，mid是root在inorder中的位置
        int mid = l2;
        while (inorder[mid] != root.val) mid++;
        //l2~ mid-1 是左子树中序
        //mid+1 ~ r2是右子树中序
        //对于前序，l1+1, l1+(mid-l2)
        //前序的r1的由中序确定， 9的下标=l1+1， 9的长度的终点下标= l1+(mid-l2)
        //9这段应该是1,1..mid-l2=1-0=1..l1+(mid-l2)=1正好
        //中序的模版是l2,mid-1
        //mid+1,l2
        //先用中序的模版，试一次或者debug一次就能试出来其他下标
        root.left = build(l1+1, l1+(mid-l2), l2, mid-1);
        //前序的l1由中序确定, [20]的下标= l1+(mid-l2)
        root.right = build(l1+1+(mid-l2), r1, mid+1, r2);
        return root;
    }
}

class SolutionP105{
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        P105ConstrunctBinaryTreeFromPreorderAndInorderTraversal p = new P105ConstrunctBinaryTreeFromPreorderAndInorderTraversal();
        p.buildTree(preorder, inorder);
    }
}
/*
给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。

 

示例 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
示例 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

提示:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder 和 inorder 均无重复元素
inorder 均出现在 preorder
preorder 保证为二叉树的前序遍历序列
inorder 保证为二叉树的中序遍历序列

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
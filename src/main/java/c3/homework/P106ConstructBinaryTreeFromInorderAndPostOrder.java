package c3.homework;

import c3.递归.TreeNode;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/*
时间O(n)
空间复杂度：O(n)
 */
public class P106ConstructBinaryTreeFromInorderAndPostOrder {
    int[] inorder;
    int[] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        return build(0, inorder.length -1, 0, postorder.length -1);
    }


    //中序，后序
    TreeNode build(int l1, int r1, int l2, int r2) {
        if (l1>r1 || l2> r2) return null;
        TreeNode root=new TreeNode(postorder[r2]);

        int mid = 0;
        while (inorder[mid] != root.val) mid++;
        //中序遍历 inorder = [9,3,15,20,7]
        //后序遍历 postorder = [9,15,7,20,3]
        //mid是root在inorder中的下标
        //先用中序的模版，试一次或者debug一次就能试出来其他下标
        root.left=build(l1,mid-1,l2,l2+(mid-l1)-1);

        root.right=build(mid+1,r1,l2+(mid-l1),r2-1);


        return root;
    }
}


class SolutionP106 {
    public static void main(String[] args) {
        P106ConstructBinaryTreeFromInorderAndPostOrder p = new P106ConstructBinaryTreeFromInorderAndPostOrder();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode root = p.buildTree(inorder, postorder);
        System.out.println(root);

    }

}

/*
106. 从中序与后序遍历序列构造二叉树
根据一棵树的中序遍历与后序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
通过次数145,286提交次数201,336

 */
package c4.binanrySearchTree;

import apple.laf.JRSUIUtils;
import c3.递归.TreeNode;

public class P0406SearchBSTNext {
    //给的是P，说明存在，给的是val，可能不在
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return inorderSuccessor(root, p.val);

        
    }

    //为了通用，写个val
    //是while，不是循环
    public TreeNode inorderSuccessor(TreeNode root, int val) {
        TreeNode ans = null;
        TreeNode curr = root;
        //检索函数
        while (curr !=null) {
            if (curr.val == val) {
                //有右子树
                if (curr.right != null) {
                    ans = curr.right;
                    //一路向左
                    while (ans.left !=null) ans = ans.left;
                }
                break;
            }
            //此处没有else


            if (val<curr.val) {
                //往左边走可能走过了，没找到，要往回走一个，所以要记下来
                //所有经过的点里选一个
                 //ans不断缩小，curr不断缩小,ans是一个比curr大的数里面最小的数
                if (ans == null || ans.val > curr.val)
                    ans = curr;
                curr = curr.left;

            }else//往右子树切换，如果是空，就返回空，后继=空
                curr = curr.right;
        }
        return ans;
    }


}

/*

面试题 04.06. 后继者
设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。

如果指定节点没有对应的“下一个”节点，则返回null。

示例 1:

输入: root = [2,1,3], p = 1

  2
 / \
1   3

输出: 2
示例 2:

输入: root = [5,3,6,2,4,null,null,1], p = 6

      5
     / \
    3   6
   / \
  2   4
 /
1

输出: null
通过次数21,687提交次数36,589


 */

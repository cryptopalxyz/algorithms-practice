package c3.树;

import apple.laf.JRSUIUtils;
import c3.递归.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
前序，中序来确定一棵树。但是这题没约定数字不重复，不能把前中序直接拿来用。

用null, null表示空子树
[1,2,3,null,null,4,5]

 */
public class P297SerializeAndDeserializeBinaryTree {

    int curr = 0;
    String[] seq ;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> seq = new ArrayList<>();
        dfs(seq, root);
        return String.join(",", seq);

    }

    void dfs(List<String> seq, TreeNode root) {
        if (root==null) {
            seq.add("null");
            return;
        }
        seq.add(String.valueOf(root.val));
        dfs(seq, root.left);
        dfs(seq, root.right);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        seq = data.split(",");
        //共享变量
        curr = 0;
        return restore();

    }

    //使用类对象，所以没有参数
    TreeNode restore() {
        //边界
        if (seq[curr].equals("null")) {
            curr++;
            //结束了，返回
            return null;
        }else {
            TreeNode root = new TreeNode(Integer.parseInt(seq[curr]));
            curr++;
            root.left = restore();
            root.right = restore();
            return root;
        }
    }


}

/*
序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。

请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。

 

示例 1：


输入：root = [1,2,3,null,null,4,5]
输出：[1,2,3,null,null,4,5]
示例 2：

输入：root = []
输出：[]
示例 3：

输入：root = [1]
输出：[1]
示例 4：

输入：root = [1,2]
输出：[1,2]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
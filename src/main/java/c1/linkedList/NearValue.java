package c1.linkedList;

//暂时放弃
  /*
public class NearValue {
    public int[] nearValue(int n, int[] nums) {
       int [] rank = new int[n];
        DoubleListNode [] pos = new DoubleListNode[n];
        for (int i=1; i<=n; i++)
            rank[i] = nums[i]; //rank = {1,5,3,4,2} nums[rank[1]] = 1,  nums[rank[2]] = 2 ,rank用来存下标
        DoubleListNode head = null;
        DoubleListNode tail = null;
        head.next = tail; //保护节点
        tail.pre = head;
        head.val = nums[rank[1]] - 99999999; //负无穷
        tail.val = nums[rank[n]] + 99999999; //正无穷

        for (int i=1; i<=n; i++) {
            pos[rank[i]] = AddNode(tail.pre, rank[i], nums);
        }

        for (int i=n; i>1;i--) {
            DoubleListNode curr = pos[i];
            if (nums[i] - curr.pre.val < nums[i] - curr.next.val)
                ans[i] = curr.pre.idx;
            else
                ans[i] = curr.next.val;

        }
        return rank;
    }
    //双链表插入模版，在node后面插入新节点node
    DoubleListNode AddNode(DoubleListNode node, int idx, int[] nums) {
        DoubleListNode newNode = new DoubleListNode();
        newNode.val = nums[idx];
        newNode.idx = idx;
        node.next.pre = newNode;

        newNode.next = node.next;
        newNode.pre = node;
        node.next = newNode;
        return newNode;
    }


}

class SolutionNearValue {
    public static void main(String[] args) {
        NearValue n = new NearValue();
        int [] nums = {1,5,3,4,2};
        n.nearValue(nums.length, nums);
    }
}
*/




/*
[1,5,3,4,2]
=>i=1, min=0,j=0
=>i=2, min=4,j=1
=>i=3, min=2,j=1
=>i=4, min=1,j=3
=>i=5, min=1,j=1

前驱，后继差值最小
比如4的前驱数3，后继是5
首先排好序，然后找前驱后继，维护有序集合

输入
3
1 5 3
输出 （第一个数字1不管，直接跳过）
4 1
2 1

通过双向链表和数组建立对应关系
https://www.acwing.com/problem/content/138/
 */
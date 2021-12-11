package c4.heap;

import c1.linkedList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
用二叉堆，
用k个指针，k个指针指向的元素看作一个堆，取最小值O(logN)
 */
public class P23MergeKSortedLists {

    ListNode head = new ListNode(0);
    ListNode tail = head;

    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n==0) return null;
        //默认小根堆，题目要求从小开始
        PriorityQueue<Node> q = new PriorityQueue<Node>(n,
                new Comparator<Node>() {
                    public int compare(Node s1, Node s2) {
                        return s1.key - s2.key;
                        //return s2.key - s1.key 是大根堆
                    }
                });

        for (ListNode node: lists) {
            if (node == null) continue;
            q.add(new Node(node.val, node));
        }
        //把K个node入queue之后，一个一个取出来
        while(!q.isEmpty()) {
            Node node = q.poll();
            tail.next = node.node;
            tail = tail.next;
            ListNode next = node.node.next;
            if (next !=null)
                q.add(new Node(next.val, next));
        }
        return head.next;
    }

}


class Node{
    int key;//用于比较
    ListNode node;
    Node(int key, ListNode node) {
        this.key = key;
        this.node = node;
    }
}
/*
给你一个链表数组，每个链表都已经按升序排列。

请你将所有链表合并到一个升序链表中，返回合并后的链表。

 

示例 1：

输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6
示例 2：

输入：lists = []
输出：[]
示例 3：

输入：lists = [[]]
输出：[]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
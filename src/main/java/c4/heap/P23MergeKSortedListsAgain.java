package c4.heap;

import c1.linkedList.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
自己实现用二叉堆，

 */

class BinaryHeap {
    List<Node> heap = new ArrayList<>();

    BinaryHeap() {
        //从1开始，0位置存一个无意义的值
        heap.add(new Node(0,null));
    }

    boolean empty() {
        return heap.size() == 1;
    }

    void insert(Node node) {
        //先放到末尾
        heap.add(node);
        heapifyUp(heap.size() -1 );
    }

    void heapifyUp(int p) {
        while (p>1) {
            if (heap.get(p).key < heap.get(p/2).key) {
                swap(heap, p, p/2);
            }else break;;
        }
    }

    void heapifyDown(int p) {
        int leftChild = p * 2;
        while (leftChild < heap.size()) {
            int other = p * 2 + 1;
            if (heap.get(other).key < heap.get(leftChild).key)
                leftChild = other; //leftchild是2孩子中小的那一个
            if (heap.get(p).key > heap.get(leftChild).key) {
                swap(heap, leftChild, p);
                p = leftChild;
                leftChild = p * 2;
            }else break;
        }
    }

    Node getMin() {
        return heap.get(1);
    }

    void deleteMin() {
        heap.set(1, heap.get(heap.size() -1));
        heap.remove(heap.size() - 1 );
        heapifyDown(1);
    }

    void swap(List heap, int p1, int p2) {
        Node tmp = (Node) heap.get(p1);
        heap.set(p1, heap.get(p2));
        heap.set(p2, tmp);

    }

}


public class P23MergeKSortedListsAgain {

    List<Node> heap = new ArrayList<>();
    ListNode head = new ListNode(0);
    ListNode tail = head;

    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n==0) return null;
        BinaryHeap q = new BinaryHeap();

        for (ListNode node: lists) {
            if (node == null) continue;
            q.insert(new Node(node.val, node));
        }
        //把K个node入queue之后，一个一个取出来
        while(!q.empty()) {
            Node node = q.getMin();
            tail.next = node.node;
            tail = tail.next;
            ListNode next = node.node.next;
            if (next !=null)
                q.insert(new Node(next.val, next));
        }
        return head.next;
    }

}

class SolutionP23 {
    public static void main(String[] args) {

        P23MergeKSortedListsAgain p = new P23MergeKSortedListsAgain();


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
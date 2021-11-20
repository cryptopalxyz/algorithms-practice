package c1.linkedList;

public class P25ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 1。分组，往后走k-1步，找到一组
        //  一组的开头head，结尾end

        ListNode protect = new ListNode(0, head);
        ListNode last = protect;


        while (head != null) {
            ListNode end = getEnd(head, k);
            if (end == null) break; //不够K，说明到最后了，不需要反转，直接退出

            ListNode nextGroupHead = end.next;
            // 2.一组内部（head和end之间）要反转（调用反转链表）
            reverseList(head, nextGroupHead);

            // 3.更新每组跟前一组，后一组之间的边
            last.next = end;
            head.next = nextGroupHead;

            last = head;
            head = nextGroupHead;
        }


        return protect.next;

    }

    //返回null表示这一组不够k个
    //返回走k-1步之后的结点
    public ListNode getEnd(ListNode head, int k) {
        while (head != null && k > 0) {
            head = head.next;
            k--;
        }
        return head;
    }


    public void reverseList(ListNode head, ListNode stop) {

        ListNode last = head;//改
        head = head.next; //改
        while (head != stop) {
            ListNode nextHead = head.next;
            head.next = last;
            last = head;
            head = nextHead;
        }
       // return last; //改
    }
}

/*

给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

进阶：

你可以设计一个只使用常数额外空间的算法来解决此问题吗？
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 

示例 1：


输入：head = [1,2,3,4,5], k = 2
输出：[2,1,4,3,5]
示例 2：


输入：head = [1,2,3,4,5], k = 3
输出：[3,2,1,4,5]
示例 3：

输入：head = [1,2,3,4,5], k = 1
输出：[1,2,3,4,5]
示例 4：

输入：head = [1], k = 1
输出：[1]
提示：

列表中节点的数量在范围 sz 内
1 <= sz <= 5000
0 <= Node.val <= 1000
1 <= k <= sz


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
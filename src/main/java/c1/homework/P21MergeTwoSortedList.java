package c1.homework;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class P21MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return  l2;
        if (l2 == null) return  l1;
        ListNode head = new ListNode();
        ListNode protect = head;

        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 !=null) {
             if (p1.val<=p2.val) {
                 head.next = p1;
                 p1 = p1.next;
                 head = head.next;
             }else {
                 head.next = p2;
                 p2 = p2.next;
                 head = head.next;

             }
        }
        if (p1 !=null) {
            head.next = p1;
            p1 = p1.next;
            head = head.next;

        }
        if (p2 !=null ) {
            head.next = p2;
            p2 = p2.next;
            head = head.next;
        }
        return protect.next;
    }
}

class SolutionP21 {
    public static void main(String[] args) {
        int [] l1 = {1,2,4};
        int [] l2 = {1,3,4};

        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l14 = new ListNode(4);

        ListNode l21 = new ListNode(1);
        ListNode l23 = new ListNode(3);
        ListNode l24 = new ListNode(4);

        l11.next = l12;
        l12.next = l14;

        l21.next = l23;
        l23.next = l24;

        P21MergeTwoSortedList p = new P21MergeTwoSortedList();
        p.mergeTwoLists(l11, l21);
    }
}
/*
1 2 4
1 3 4

  2 4
1 3 4

head->1
*/

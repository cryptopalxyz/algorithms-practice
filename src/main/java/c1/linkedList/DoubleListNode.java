package c1.linkedList;

public class DoubleListNode {
    int val;
    int idx;
    DoubleListNode next;
    DoubleListNode pre;

    DoubleListNode() {
    }

    DoubleListNode(int val) {
        this.val = val;
    }

    DoubleListNode(int val, int idx, DoubleListNode pre, DoubleListNode next) {
        this.val = val;
        this.idx = idx;
        this.next = next;
        this.pre = pre;
    }
}

package c1.linkedList;

public class DoubleListNode {
    public int val;
    public int idx;
    public DoubleListNode next;
    public DoubleListNode pre;

    public DoubleListNode() {
    }

    public DoubleListNode(int val) {
        this.val = val;
    }

    public DoubleListNode(int val, int idx, DoubleListNode pre, DoubleListNode next) {
        this.val = val;
        this.idx = idx;
        this.next = next;
        this.pre = pre;
    }
}

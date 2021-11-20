package c1.homework;

import c1.stack.P84LargestRectangleInHistogram;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//start是保护节点，并不在队列里面，队列的第一个节点是start.next,
//end是最后一个节点
public class P64MyCircularDeque {

    int capacity;
    int curContain = 0;

    class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        public ListNode(int val) {
            this.val = val;
        }
    }

    ListNode start;
    ListNode end;


    public P64MyCircularDeque(int k) {
        this.capacity = k;
        start = new ListNode(0);
        end = start;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        ListNode newNode = new ListNode(value);
        if (isEmpty()) {
            start.next = newNode;
            end = newNode;
            end.prev = start;
            newNode.next = null;
        }else {
            newNode.next = start.next;
            newNode.prev = start;
            start.next = newNode;
            start.next.next.prev = start.next;
        }

        curContain++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        ListNode newNode = new ListNode(value);
        end.next = newNode;
        newNode.prev = end;
        end = newNode;
        curContain++;
        return  true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        if (curContain == 1) {
            start.next = null;
            end = start;

            //curContain = 0;
        }else {

                start.next = start.next.next;

        }
        curContain--;
        return true;
    }
//1  2


    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (curContain == 1) {
            start.next = null;
            end = start;
            end.prev = null;
            //curContain = 0;
        }else {
            end = end.prev;
            //end.next = null;
        }
        curContain--;
        return true;
    }
//1 2
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return start.next.val;

    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return end.val;
    }

    public boolean isEmpty() {
        return start == end;
    }

    public boolean isFull() {
        return capacity == curContain;
    }
}

class SolutionP64 {
    public static void main(String[] args) {

        P64MyCircularDeque circularDeque = new P64MyCircularDeque(77); // 设置容量大小为3
        circularDeque.insertFront(89);
        circularDeque.getRear();
        circularDeque.deleteLast();
        circularDeque.getRear();
        circularDeque.insertFront(19);
        circularDeque.insertFront(23);
        circularDeque.insertFront(23);
        circularDeque.insertFront(82);
        circularDeque.isFull();
        circularDeque.insertFront(45);
        circularDeque.isFull();
        circularDeque.getRear();
        circularDeque.deleteLast();
        circularDeque.getFront();
        circularDeque.insertLast(74);
        circularDeque.deleteFront();
        circularDeque.getFront();
        circularDeque.insertLast(98);
//   82 23 23 19 74



    }
}
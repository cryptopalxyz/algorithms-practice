package c2.缓存;

import c1.linkedList.DoubleListNode;

import java.util.HashMap;
import java.util.HashSet;

/*
哈希+双向链表
O(1) 访问
O(1) 更新
O(1) 删除
 */
public class P146LRUCache {
    int capacity;
    DoubleListNode head;
    DoubleListNode tail;
    HashMap<Integer, DoubleListNode> map = new HashMap<>();

    public P146LRUCache(int capacity) {
        this.capacity = capacity;
        //head tail都是保护结点，不存值
        this.head = new DoubleListNode();
        this.tail = new DoubleListNode();
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();

    }

    public int get(int key) {
        if (map.containsKey(key)) {
            //删掉，在插入到到开头
            DoubleListNode node = map.get(key);
            remove(node);
            insert(head, node);
            return node.val;

        }

        return -1;

    }

    //存在就更新，不存在就新建
    //node需要存key 和value，key为了用这个key来删除map
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DoubleListNode node = map.get(key);
            node.idx = key;
            node.val = value;

            remove(node);
            insert(head, node);
        }else {
            DoubleListNode node =  new DoubleListNode();
            node.idx = key;
            node.val = value;
            insert(head, node);
            map.put(key, node);
            //过大，把tail前面一个删掉
            if (map.size() > capacity) {
                map.remove(tail.pre.idx); //idx as key
                remove(tail.pre);

            }
        }

    }

    public void remove(DoubleListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;

    }

    public void insert(DoubleListNode head, DoubleListNode node) {
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }
}

class SolutionP146 {
    public static void main(String[] args) {
        P146LRUCache p = new P146LRUCache(2);
        p.put(1, 0);
        p.put(2,2);
        System.out.println(p.get(1));
        p.put(3,3);
        System.out.println(p.get(2));
        p.put(4,4);
        System.out.println(p.get(1));
        System.out.println(p.get(3));
        System.out.println(p.get(4));


    }
}
/*
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
实现 LRUCache 类：

LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 

进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？

 

示例：

输入
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
输出
[null, null, null, 1, null, -1, null, -1, 3, 4]

解释
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // 缓存是 {1=1}
lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
lRUCache.get(1);    // 返回 1
lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
lRUCache.get(2);    // 返回 -1 (未找到)
lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
lRUCache.get(1);    // 返回 -1 (未找到)
lRUCache.get(3);    // 返回 3
lRUCache.get(4);    // 返回 4
 

提示：

1 <= capacity <= 3000
0 <= key <= 10000
0 <= value <= 105
最多调用 2 * 105 次 get 和 put


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lru-cache
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
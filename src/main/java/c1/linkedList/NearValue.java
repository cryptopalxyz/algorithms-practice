package c1.linkedList;

//暂时放弃

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
1. 准备一个数组链表，数组和链表结合可以快速删除；
2。 从后往前，每次删除一个，找到前驱或者后继
下面的代码不对

 */
public class NearValue {
    public int[] nearValue(int n, int[] nums) {
        int[] ans = new int[nums.length];
        Integer[] rank = new Integer[n];//必须用Integer，为了下面用Arrays.sort
        DoubleListNode[] pos = new DoubleListNode[n];
        for (int i = 0; i < n; i++)
            rank[i] = i; //rank = {1,5,3,4,2} nums[rank[1]] = 1,  nums[rank[2]] = 2 ,rank用来存下标
        //rank[1]=1; rank[2]=2;
        //从小到大排序
        Arrays.sort(rank, ( i,  j) -> { return nums[i] - nums[j];});

        //rank变成了下标数组 (0, 4, 2 ,3 ,1)

        // 建立链表

        DoubleListNode head = new DoubleListNode((int) (nums[rank[0]]-1e9));
        DoubleListNode tail = new DoubleListNode((int) (nums[rank[n-1]]+1e9));
        head.next = tail;
        tail.pre = head;
        for (int i=0; i<n; i++) {
            pos[rank[i]] = AddNode(tail.pre, rank[i], nums);
        }

        //准备条件好了
        for(int i=n-1; i>0; i--) {
            DoubleListNode curr = pos[i];
            if ((nums[i] - curr.pre.val) <=(curr.next.val - nums[i] )) {
                ans[i] = curr.pre.idx;
            }
            else
                ans[i] = curr.next.idx;
            DeleteNode(curr);
        }

        for (int i=0;i<ans.length;i++)
            ans[i]++;

        return ans;
    }

    //双链表插入模版，在node后面插入新节点node
    DoubleListNode AddNode(DoubleListNode node, int idx, int[] nums) {
        DoubleListNode n = new DoubleListNode();
        n.val = nums[idx];
        n.idx = idx;
        n.pre = node;
        node.next.pre = n;
        n.next = node.next;

        node.next = n;


        return n;
    }

    void DeleteNode(DoubleListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }


}

class SolutionNearValue {
    public static void main(String[] args) {

        NearValue nearValue = new NearValue();
        int[] nums = {1, 5, 3, 4, 2};
        int[] ans = nearValue.nearValue(nums.length , nums);
        System.out.println(ans);
    }
}





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

按数值排序，建立有序双链表
链表虽然不能随机访问，但可以记录A数组每个下标对应的链表结点
倒序考虑每个下标，只需要在链表中查找前驱，后继，然后删除结点

关键点
索引的灵活性-按下标/按值
不同索引的数据结构之间建立映射关系
倒叙考虑问题


输入
3
1 5 3
输出 （第一个数字1不管，直接跳过）
4 1
2 1

通过双向链表和数组建立对应关系
https://www.acwing.com/problem/content/138/
 */
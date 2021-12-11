package c4.BFS;


import java.util.*;

/*
就是图里求层数，用BFS
 */
public class P433MinGeneticMutation {
    HashMap<String, Integer> depth = new HashMap<>();


    public int minMutation(String start, String end, String[] bank) {
        List<String> list = Arrays.asList(bank);
        //this.depth = depth;
        //this.hashBank = hashBank;
        depth.put(start, 0);

        Deque<String> q = new LinkedList<>();
        q.push(start);
        char[] gene = {'A','C','G','T'};
        //这块是模版，非空取队头，pop掉
        while (!q.isEmpty()) {
            String s = q.getFirst();
            q.pop();
         //这块是模版，非空取队头，pop掉
            for( int i=0; i<8; i++)//8个字母
                for (int j=0; j<4;j++)//ACGT
                    if(!String.valueOf(s.charAt(i)).equals(gene[j]))   {
                        String ns = s.substring(0, i) + gene[j] + s.substring(i + 1, s.length()); //变化一个位置的字符后形成新的字符串

                        //ns not in list
                        if(!list.contains(ns)) continue;
                        //只走一次，BFS第一次的层数最少,
                        if (depth.containsKey(ns)) continue;
                        depth.put(ns, depth.get(s) + 1);
                        //add to the tail of the deque
                        //push is to head of the deque
                        q.add(ns);
                        //string比较要用equals
                        if (ns.equals(end))
                            return depth.get(ns);
                    }
        }

        return  -1;

    }
}

class P433Solution {
    public static void main(String[] args) {
        String start= "AAAACCCC";
        String end=  "CCCCCCCC";
        String[] bank= { "AAAACCCA","AAACCCCA","AACCCCCA","AACCCCCC","ACCCCCCC","CCCCCCCC","AAACCCCC","AACCCCCC"};
        P433MinGeneticMutation p = new P433MinGeneticMutation();
        p.minMutation(start, end, bank);
    }
}

/*
433. 最小基因变化
一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。

假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。

例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。

与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。

现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。

注意：

起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
如果一个起始基因序列需要多次变化，那么它每一次变化之后的基因序列都必须是合法的。
假定起始基因序列与目标基因序列是不一样的。


示例 1：

start: "AACCGGTT"
end:   "AACCGGTA"
bank: ["AACCGGTA"]

返回值: 1
示例 2：

start: "AACCGGTT"
end:   "AAACGGTA"
bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]

返回值: 2
示例 3：

start: "AAAAACCC"
end:   "AACCCCCC"
bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]

返回值: 3
 */
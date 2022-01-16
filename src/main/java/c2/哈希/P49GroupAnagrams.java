package c2.哈希;

import java.lang.reflect.Array;
import java.util.*;

import static com.sun.tools.doclint.Entity.copy;

/*
分组用哈希
把字母从小到大排序，""
1。先排序
2。按个来找一类

 */

//直接做成hash，散列表
//hash函数是变成char[] 再排序，再变成string比较是否一致
//复杂度取决于快排，时间复杂度最好O(nlogn)，最差O(n2)
//空间复杂度最好O(n),最差o(logn)
public class P49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            char[] array = s.toCharArray();
            Arrays.sort(array); //把str先变成CharArray，再排序，异位词有相同的CharArray，即相同的key，放入map
            String key = new String(array);
            List<String > list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        return new ArrayList<>( map.values());

    }

}

/*
给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。

 

示例 1:

输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
示例 2:

输入: strs = [""]
输出: [[""]]
示例 3:

输入: strs = ["a"]
输出: [["a"]]
 



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/group-anagrams
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
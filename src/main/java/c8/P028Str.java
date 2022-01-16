package c8;

import java.util.Arrays;

public class P028Str {
    public int strStr(String haystack, String needle) {
        int b= 131;
        int p = (int) (1e9 +7);
        int m = haystack.length();
        int n = needle.length();
        long[] H = new long[n+1];
        long powBM = 1;
        Arrays.fill(H, 0);
        //a=1, b=2...z=26
        for (int i=1; i<=n; i++)
            H[i] = (H[i-1] * 131 + haystack.charAt(i-1) - 'a' + 1) % p;

        long Hneedle = 0;
        for (char ch: needle.toCharArray()) {
            Hneedle = (Hneedle * b + (ch - 'a' + 1)) % p;
            powBM = powBM * b % p;
        }

        for (int l=1; l<=n-m+1;l++) {
            int r = l +m -1;
            //避免负数
           if (((H[r] - H[l-1] * powBM) % p + p)%p == Hneedle )
            return l-1;
        }

        return  -1;
    }

}

/*
28. 实现 strStr()
实现 strStr() 函数。

给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。



说明：

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。



示例 1：

输入：haystack = "hello", needle = "ll"
输出：2
示例 2：

输入：haystack = "aaaaa", needle = "bba"
输出：-1
示例 3：

输入：haystack = "", needle = ""
输出：0
 */
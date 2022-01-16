package c8;


/*

哈希加二分
O(NLongN)

奇数回文串以中间字符为中心

以每个字符为中心，向两边扩展
枚举O（N），拓展O（N）
朴素

1个1个拓展比较慢，
给定长度，用二分，和哈希来来判断是否可以拓展

 */
public class P005LongestPalindromicSubstringOptimized {
    public String longestPalindrome(String s) {
        int n = s.length();
        int anslen = 0;
        int ansStart = 0;

        //奇数 aba
        /*
        center=0, l=-1, r = 1 超范围
        center=1, l=0, r=2 相等，l=-1,r=3, anslen=3, anStart=1,
        center=2, l=1, r=3 超范围，

         */
        for (int center =0; center<n; center++) {
            int l = center- 1, r = center + 1;
            while (l>=0 && r<n && s.charAt(l) == s.charAt(r)) { l--;r++;}
            if (r-l - 1 > anslen) {//为什么不是r-l (l+1,r-1)  因为++了所以要用之前的值，所以说是(l+1,r-1)， (r-1)-(l+1)+1=r-l-1
                anslen = r - l - 1;
                ansStart = l + 1;

            }
        }

        //偶数 abba
        /*
        center=0, l=-1, r = 0 超范围
        center=1, l=0, r=1
        center=2, l=1, r=2 相等,anslen=2, anstart=1
        center=3, l=2, r=3 不相等
        center=4，l=3, r=

         */
        for (int center =1; center<n; center++) {
            int l = center- 1, r = center ;
            while (l>=0 && r<n && s.charAt(l) == s.charAt(r)) { l--;r++;}
            if (r-l - 1 > anslen) { //(l+1,r-1)
                anslen = r - l - 1;
                ansStart = l + 1;

            }
        }

        return s.substring(ansStart, anslen+ansStart);
    }
}

class SolutionP005Optimized {
    public static void main(String[] args) {
        P005LongestPalindromicSubstring p = new P005LongestPalindromicSubstring();
        String s = "babad";
        p.longestPalindrome(s);

    }
}


/*

5. 最长回文子串
给你一个字符串 s，找到 s 中最长的回文子串。



示例 1：

输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
示例 2：

输入：s = "cbbd"
输出："bb"
示例 3：

输入：s = "a"
输出："a"
示例 4：

输入：s = "ac"
输出："a"


提示：

1 <= s.length <= 1000
s 仅由数字和英文字母（大写和/或小写）组成


 */
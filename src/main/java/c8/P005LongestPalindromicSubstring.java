package c8;


/*

哈希加二分
O(NLongN)

奇数回文串以中间字符为中心

以每个字符为中心，向两边扩展
枚举O（N），拓展O（N）
朴素

 */
public class P005LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        int anslen = 0;
        int ansStart = 0;
        //奇数
        for (int center =0; center<n; center++) {
            int l = center- 1, r = center + 1;
            while (l>=0 && r<n && s.charAt(l) == s.charAt(r)) { l--;r++;}
            if (r-l - 1 > anslen) { //为什么不是r-l (l+1,r-1)  因为++了所以要用之前的值，所以说是(l+1,r-1)， (r-1)-(l+1)+1=r-l-1
                anslen = r - l - 1;
                ansStart = l + 1;

            }
        }

        //偶数
        for (int center =1; center<n; center++) {
            int l = center- 1, r = center ;
            while (l>=0 && r<n && s.charAt(l) == s.charAt(r)) { l--;r++;}
            if (r-l - 1 > anslen) { //为什么不是r-l (l+1,r-1)  因为++了所以要用之前的值，所以说是(l+1,r-1)， (r-1)-(l+1)+1=r-l-1
                anslen = r - l - 1;
                ansStart = l + 1;

            }
        }
        //bigin index, end index
        return s.substring(ansStart, ansStart+anslen);
    }
}

class SolutionP005 {
    public static void main(String[] args) {
        P005LongestPalindromicSubstring p = new P005LongestPalindromicSubstring();
        String s = "cbbd";
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
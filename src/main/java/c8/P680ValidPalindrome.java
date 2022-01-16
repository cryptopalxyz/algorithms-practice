package c8;

public class P680ValidPalindrome {
    public boolean validPalindrome(String s) {
        return check(s, 0, s.length() -1, 1);

    }

    boolean check(String s, int l, int r, int times) {

        boolean deleted = false;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return  times>0 && ( check(s, l+1, r, 0) ||check(s, l, r-1, 0));
            l++;
            r--;
        }
        return true;
    }
}

/*
680. 验证回文字符串 Ⅱ
给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。



示例 1:

输入: s = "aba"
输出: true
示例 2:

输入: s = "abca"
输出: true
解释: 你可以删除c字符。
示例 3:

输入: s = "abc"
输出: false


提示:

1 <= s.length <= 105
s 由小写英文字母组成

 */
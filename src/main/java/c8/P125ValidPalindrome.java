package c8;

import java.util.ArrayList;
import java.util.List;

public class P125ValidPalindrome {
    public boolean isPalindrome(String s) {
        List<Character> t = filter(s);
        //双指针
        for (int i=0, j = t.size() -1; i<j; i++,j--) {
            if (t.get(i) != t.get(j)) return false;
        }

        return true;

    }


    public List<Character> filter(String s) {
        List<Character> t = new ArrayList<>();
        for (char ch: s.toCharArray()) {
            if ((ch >='0' && ch <='9') || (ch >='a' && ch <='z'))
                t.add(ch);
            if (ch >='A' && ch <='Z')
                t.add((char) (ch - 'A' + 'a'));
        }
        return t;
    }
}

class solutionP125 {
    public static void main(String[] args) {
        P125ValidPalindrome p = new P125ValidPalindrome();
        String s = "A man, a plan, a canal: Panama";
        p.isPalindrome(s);
    }
}

/*
125. 验证回文串
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。



示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
解释："amanaplanacanalpanama" 是回文串
示例 2:

输入: "race a car"
输出: false
解释："raceacar" 不是回文串


 */
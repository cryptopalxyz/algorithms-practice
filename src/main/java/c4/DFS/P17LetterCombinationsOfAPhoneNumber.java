package c4.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P17LetterCombinationsOfAPhoneNumber {

    HashMap<Character, String> alphabet = new HashMap<>();
    List<String> ans = new ArrayList<>();
    String digits;

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        if (digits== null || digits.length() == 0 ) return ans;

        alphabet.put('0', "");
        alphabet.put('1', "");
        alphabet.put('2', "abc");
        alphabet.put('3', "def");
        alphabet.put('4', "ghi");
        alphabet.put('5', "jkl");
        alphabet.put('6', "mno");
        alphabet.put('7', "pqrs");
        alphabet.put('8', "tuv");
        alphabet.put('9', "wxyz");

        //开始
        dfs(0,"");
        return ans;


    }

    void dfs(int index, String str) {
        //边界
        if (index == digits.length()) {
            ans.add(str);
            return;

        }
        for (Character ch: alphabet.getOrDefault(digits.charAt(index),"").toCharArray()) {
            //如果改了str的值，那么需要还原现场
            str += ch;
            dfs(index + 1, str);
            str = str.substring(0, str.length()-1);
            //另一种写法,不需要操作str和还原现场
           // dfs(index + 1, str+ch);
        }

    }

}

class SolutionP17 {
    public static void main(String[] args) {
        P17LetterCombinationsOfAPhoneNumber p = new P17LetterCombinationsOfAPhoneNumber();
        String digits = "23";
        p.letterCombinations(digits);
    }
}
/*
17. 电话号码的字母组合
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。





示例 1：

输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
示例 2：

输入：digits = ""
输出：[]
示例 3：

输入：digits = "2"
输出：["a","b","c"]


提示：

0 <= digits.length <= 4
digits[i] 是范围 ['2', '9'] 的一个数字。
 */
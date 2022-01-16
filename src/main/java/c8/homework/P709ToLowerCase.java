package c8.homework;

import java.util.ArrayList;
import java.util.List;

public class P709ToLowerCase {
    public String toLowerCase(String s) {

        if (s == null)
            return null;

        List<Character> chList = new ArrayList<>();

        for (char ch: s.toCharArray()) {
            if (ch<'a' && ch >='A' && ch<='Z')
                ch = (char) (ch + 'a' - 'A');
            chList.add(ch);
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch: chList){
            sb.append(ch);
        }
        return sb.toString();

    }
}

class SolutionP709 {
    public static void main(String[] args) {
        P709ToLowerCase p = new P709ToLowerCase();
        System.out.println(p.toLowerCase("Hello"));
    }
}

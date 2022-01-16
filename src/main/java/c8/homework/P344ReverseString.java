package c8.homework;

public class P344ReverseString {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0)
            return;

        int n = s.length;
        char tmp ;

        for (int i=0; i<n; i++) {
            if (i>=n/2) break;
            tmp = s[i];
            s[i] = s[n-i-1];
            s[n-i-1] = tmp;
        }
    }
}

class SolutionP344 {
    public static void main(String[] args) {
        P344ReverseString p = new P344ReverseString();
        char[]s = {'H','a','n','n','a','h'};
        p.reverseString(s);
        System.out.println(s);
    }
}

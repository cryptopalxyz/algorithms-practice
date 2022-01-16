package c8;

public class P008Atoi {
    int myAtoi(String s) {

        int index =0;
        //1. 忽略前导空格
        while (index < s.length() && s.charAt(index) == ' ')
            index++;

        //2. 正负号
        int sign = 1;
        if (index < s.length() && (s.charAt(index) == '-' ||s.charAt(index) == '+' ) ) {
            sign = s.charAt(index) == '-' ? -1 : 1;
            index++;
        }
        //3. 处理数字直到非数字
        long val = 0;
        while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <='9' ) {
            if (val * 10 + ( s.charAt(index) - '0')  > Math.pow(2,31) -1 )  {
                if (sign == 1)
                    return (int) (Math.pow(2,31));
                else
                    return (int) ((int) sign *  (Math.pow(2,31) ));
            }

            val = val * 10 + ( s.charAt(index) - '0');
            index ++;
        }

        return (int) (sign * val);
    }
}

class SolutionP008 {
    public static void main(String[] args) {
       long a = (long) Math.pow(2,31);
       System.out.println(a);
       P008Atoi p = new P008Atoi();
       p.myAtoi(" -42");
    }
}

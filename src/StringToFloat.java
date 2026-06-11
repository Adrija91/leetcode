
public class StringToFloat {
    public static float myAtoifloat(String s)
    {
        int i = 0;
        int n = s.length();

        // Skip leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Handle sign
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        double num = 0;

        while (i < n && Character.isDigit(s.charAt(i))) {
            double digit = s.charAt(i) - '0';
            num = num * 10 + digit;
            i++;
        }

        if(i<n && s.charAt(i)=='.')
        {
            i++;
            double place = 0.1;

            while(i<n && Character.isDigit(s.charAt(i)))
            {
                double digit = s.charAt(i) - '0';
                num=num+digit*place;
                place = place/10;
                i++;
            }
        }

        return (float)(sign * num);
    }

    public static void main(String[] args) {

       System.out.println(myAtoifloat("45.2"));                // 42
//        System.out.println(myAtoifloat("   -42"));           // -42
//        System.out.println(myAtoifloat("1337c0d3"));          // 1337
//        System.out.println(myAtoifloat("0-1"));              // 0
//       System.out.println(myAtoifloat("words and 987"));    // 0
//        System.out.println(myAtoifloat("-91283472332"));     // -2147483648
    }
}

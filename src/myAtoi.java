public class myAtoi {

    public static int myAtoi(String s) {

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

        // Build the number
        long num = 0;

        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            num = num * 10 + digit;

            // Overflow check
            if (sign * num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (sign * num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int) (sign * num);
    }

    public static void main(String[] args) {

//        System.out.println(myAtoi("42"));                // 42
        System.out.println(myAtoi("   -042"));           // -42
//        System.out.println(myAtoi("1337c0d3"));          // 1337
//        System.out.println(myAtoi("0-1"));              // 0
//        System.out.println(myAtoi("words and 987"));    // 0
//        System.out.println(myAtoi("-91283472332"));     // -2147483648
    }
}
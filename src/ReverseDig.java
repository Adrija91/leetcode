public class ReverseDig {

    public int reverse(int x) {
        int rev = 0;

        while (x != 0) {
            int dig = x % 10;
            x /= 10;

            // Positive overflow check
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && dig > 7)) {
                return 0;
            }

            // Negative underflow check
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && dig < -8)) {
                return 0;
            }

            rev = (rev * 10) + dig;
        }
        return rev;
    }

    public static void main(String[] args) {
        ReverseDig solution = new ReverseDig();

        // Test cases
        int input = 123;
        System.out.println("Original: " + input + " | Reversed: " + solution.reverse(input));

        input = -456;
        System.out.println("Original: " + input + " | Reversed: " + solution.reverse(input));

        input = 1534236469; // Will trigger overflow (return 0)
        System.out.println("Original: " + input + " | Reversed: " + solution.reverse(input));
    }
}
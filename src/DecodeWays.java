public class DecodeWays {

    public int numDecodings(String s) {

        int[] dp = new int[s.length() + 1];

        dp[0] = 1;

        if (s.charAt(0) == '0') {
            dp[1] = 0;
        } else {
            dp[1] = 1;
        }

        for (int i = 2; i < dp.length; i++) {

            // Single digit decode
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }

            // Two digit decode
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));

            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {

        DecodeWays solution = new DecodeWays();

        String s = "26";

        int result = solution.numDecodings(s);

        System.out.println("Number of ways to decode: " + result);
    }
}
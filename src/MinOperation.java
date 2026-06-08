import java.util.*;

public class MinOperation {

    Map<Integer, Integer> memo = new HashMap<>();

    public int minOperations(int n) {

        if (n == 0) return 0;

        // check if power of 2
        if ((n & (n - 1)) == 0) return 1;

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int power = 1;

        while (power < n) {
            power <<= 1;
        }

        int ans = 1 + Math.min(
                minOperations(n - (power >> 1)),
                minOperations(power - n)
        );

        memo.put(n, ans);

        return ans;
    }

    public static void main(String[] args) {

        MinOperation obj = new MinOperation();

        System.out.println(obj.minOperations(39));
    }
}
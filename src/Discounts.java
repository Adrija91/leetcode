import java.util.Stack;
import java.util.Arrays;

public class Discounts {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] answer = prices.clone();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int index = stack.pop();
                answer[index] = prices[index] - prices[i];
            }
            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Discounts sol = new Discounts();
        int[] prices = {8, 4, 6, 2, 3};
        int[] result = sol.finalPrices(prices);
        System.out.println("Final Prices: " + Arrays.toString(result));
    }
}
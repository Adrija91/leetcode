import java.util.Arrays;

public class isGoodArray {

    public boolean check(int[] nums) {
        // 1. Handle potential empty or null inputs to prevent errors
        if (nums == null || nums.length < 2) {
            return false;
        }

        // 2. Sort the array so the numbers are in sequence: [1, 2, ..., n-1, n, n]
        Arrays.sort(nums);

        // 3. Define n based on the definition of a "good" array: 
        // A "good" array of length m has a maximum value n = m - 1
        int n = nums.length - 1;

        // 4. Loop through the first n-1 elements to verify the 1, 2, 3... pattern
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] != i + 1) {
                return false;
            }
        }

        // 5. Final check: the last two elements must both equal n
        return nums[n - 1] == n && nums[n] == n;
    }

    public static void main(String[] args) {
        isGoodArray solver = new isGoodArray();

        // Example tests
        int[] testData = {2, 1, 3, 3};
        System.out.println("Is good array: " + solver.check(testData));
    }
}
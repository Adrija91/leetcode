import java.util.Arrays;

public class Permutation {
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        // 1. Find the pivot
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            // 2. Find the successor
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // 3. Swap
            swap(nums, i, j);
        }

        // 4. Reverse the suffix (everything after index i)
        reverse(nums, i + 1, n - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 5, 8, 4, 7, 6, 2};

        System.out.println("Original: " + Arrays.toString(nums));

        nextPermutation(nums);

        System.out.println("Next:     " + Arrays.toString(nums));
    }
}
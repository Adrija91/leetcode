import java.util.Arrays;

public class MoveZeroesToFront {

    public void moveZeroesToFront(int[] nums) {

        int write = nums.length - 1;

        // Place non-zero elements from right to left
        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] != 0) {
                nums[write] = nums[i];
                write--;
            }
        }

        // Fill remaining positions with 0
        while (write >= 0) {
            nums[write] = 0;
            write--;
        }
    }

    public static void main(String[] args) {

        MoveZeroesToFront solution = new MoveZeroesToFront();

        int[] nums = {1, 0, 2, 0, 3};

        solution.moveZeroesToFront(nums);

        System.out.println(Arrays.toString(nums));
    }
}
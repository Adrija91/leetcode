import java.util.Arrays;

public class MoveZeroesToBack {

    public void moveZeroesToBack(int[] nums) {

        int n =  nums.length - 1;

        int write = 0;

        for (int i = 0; i <= n; i++) {

            if(nums[i]!=0)
            {
                nums[write]=nums[i];
                write++;
            }
        }

        while (write < nums.length) {
            nums[write] = 0;
            write++;
        }
    }

    public static void main(String[] args) {

        MoveZeroesToBack solution = new MoveZeroesToBack();

        int[] nums = {1, 0, 2, 0, 3};

        solution.moveZeroesToBack(nums);

        System.out.println(Arrays.toString(nums));
    }
}
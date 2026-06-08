import java.util.HashMap;

public class MaxSubarray {
    public int subarraySum(int[] nums) {
        int currSum = 0;
        int max_s = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++)
        {
            currSum = currSum + nums[i];
            if(max_s<currSum)
            {
                max_s = currSum;
            }
            if(currSum<0)
            {
                currSum=0;
            }
        }
        return max_s;
    }

    public static void main(String[] args) {
        MaxSubarray solution = new MaxSubarray();
        int[] nums = {0, -1, -1};
        System.out.println(solution.subarraySum(nums)); // Should print 2
    }
}
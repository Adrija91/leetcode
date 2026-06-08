import java.util.*;

class threesum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        // Step 1: sort the array
        Arrays.sort(nums);

        // Step 2: fix one number
        for (int i = 0; i < nums.length - 2; i++) {

            // skip duplicate starting numbers
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            // Step 3: two pointer search
            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                // triplet found
                if (sum == 0) {

                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // skip duplicate left values
                    while (left < right &&
                            nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // skip duplicate right values
                    while (left < right &&
                            nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                }

                // need bigger sum
                else if (sum < 0) {
                    left++;
                }

                // need smaller sum
                else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        threesum sol = new threesum();

        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> answer = sol.threeSum(nums);

        System.out.println(answer);
    }
}


//runtime O(n^2)
//Space O(1)
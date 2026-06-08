public class FindMinimumRotatedArray {

    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length -1;
        int mid = 0;

        while (left < right) {

            mid = (left + right) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            else
            {
                right--;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {

        FindMinimumRotatedArray obj =
                new FindMinimumRotatedArray();

        int[] nums = {3,4,5,6,1,2};

        int result = obj.findMin(nums);

        System.out.println("Minimum = " + result);
    }
}
public class SearchSortedArray {

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left+right)/2;

            if (nums[mid] == target) {
                return mid;
            }

            if(nums[left]<=nums[mid])
            {
                if(nums[left]<=target && target<nums[mid])
                {
                    right=mid-1;
                }
                else {
                    left=mid+1;
                }
            }
            else
            {
                if (nums[mid] < target && target <= nums[right])
                {
                    left=mid+1;
                }
                else {
                    right=mid-1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        SearchSortedArray obj = new SearchSortedArray();

        int[] nums = {3,4,5,6,1,2};
        int target = 1;

        int result = obj.search(nums, target);

        System.out.println(result);
    }
}
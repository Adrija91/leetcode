import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            sum += num;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 1, 1};
        int k1 = 2;

        System.out.println(subarraySum(nums1, k1));
        // Output: 2

        int[] nums2 = {1, 2, 3};
        int k2 = 3;

        System.out.println(subarraySum(nums2, k2));
        // Output: 2
    }
}
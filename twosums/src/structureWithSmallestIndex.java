import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class structureWithSmallestIndex {
    public int[] smallesIndex(int[] nums, int target) {

        HashMap<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hmap.put(nums[i], i);
        }

        int[] best = new int[2];
        best[0] = Integer.MAX_VALUE;
        best[1] = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (hmap.containsKey(complement) && hmap.get(complement) != i) {
                int first = Math.min(i, hmap.get(complement));
                int second = Math.max(i, hmap.get(complement));

                if (first < best[0] || (first == best[0] && second < best[1])) {
                    best[0] = first;
                    best[1] = second;
                }
            }
        }

        return best;
    }
    public static void main(String[] args) {

        structureWithSmallestIndex solution = new structureWithSmallestIndex();

        int[] nums = {2, 7, 11, 15, 3, 6};
        int target = 9;

        int[] result = solution.smallesIndex(nums, target);

        System.out.println(Arrays.toString(result));
    }
}

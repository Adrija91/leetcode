import java.util.HashMap;

public class countPairs {

    public int countPairs(int[] nums, int target) {

        HashMap<Integer, Integer> freq = new HashMap<>();
        int count = 0;

        for (int num : nums) {

            int diff = target - num;

            if (freq.containsKey(diff)) {
                count += freq.get(diff);
            }

            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        countPairs solution = new countPairs();

        int[] nums = {3,3,3,3};
        int target = 6;

        System.out.println(solution.countPairs(nums, target));
    }
}
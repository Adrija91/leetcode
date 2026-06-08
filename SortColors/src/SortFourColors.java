import java.util.*;

public class SortFourColors {

    public void sortColors(int[] nums) {

        HashMap<Integer, Integer> hmap = new HashMap<>();

        for (int num : nums) {
            hmap.put(num, hmap.getOrDefault(num, 0) + 1);
        }

        List<Integer> keys = new ArrayList<>(hmap.keySet());
        Collections.sort(keys);

        int index = 0;

        for (int key : keys) {

            int freq = hmap.get(key);

            while (freq > 0) {
                nums[index++] = key;
                freq--;
            }
        }
    }

    public static void main(String[] args) {

        SortFourColors solution = new SortFourColors();

        int[] nums = {30, 10, 20, 10, 30, 40};

        solution.sortColors(nums);

        System.out.println(Arrays.toString(nums));
    }
}
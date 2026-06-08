import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public boolean hasDuplicate(int[] nums) {

        Set<Integer> hset = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (hset.contains(nums[i])) {
                return true;
            } else {
                hset.add(nums[i]);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        ContainsDuplicate obj = new ContainsDuplicate();

        int[] nums = {1, 2, 3, 1};

        boolean result = obj.hasDuplicate(nums);

        System.out.println(result);
    }
}
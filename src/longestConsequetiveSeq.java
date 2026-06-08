import java.util.Arrays;
import java.util.HashSet;

public class longestConsequetiveSeq {

    public int longestConsecutive(int[] nums) {

        HashSet<Integer> hset = new HashSet<>();

        for (int i : nums) {
            hset.add(i);
        }

        int count = 0;
        int curr = 0;
        int longest = 0;

        for (int n : hset) {

            if (!hset.contains(n - 1)) {
                count = 1;
                curr = n;
            }

            while (hset.contains(curr + 1)) {
                count++;
                curr++;
            }
            longest = Math.max(longest, count);
        }


        return longest;
    }

    public static void main(String[] args) {

        longestConsequetiveSeq obj = new longestConsequetiveSeq();

        int[] nums = {100,4,200,1,3,2};

        System.out.println(obj.longestConsecutive(nums));
    }
}
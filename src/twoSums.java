import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class twoSums {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hmap = new HashMap<>();

        for(int i =0;i<nums.length;i++)
        {
            hmap.put(nums[i],i);
        }

        ArrayList<Integer> al = new ArrayList<>();

        for(int i=0; i < nums.length; i++)
        {
            int diff = target - nums[i];
            if(hmap.containsKey(diff) && hmap.get(diff)!=i)
            {
                al.add(i);
                al.add(hmap.get(diff));
                break;
            }
        }
        int[] res = new int[al.size()];
        for (int i = 0; i < al.size(); i++)
        {
            res[i] = al.get(i);
        }
        return res;
    }

    public static void main(String[] args) {

        twoSums obj = new twoSums();

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = obj.twoSum(nums, target);

        System.out.println(Arrays.toString(result));
    }
}
import java.util.ArrayList;
import java.util.Arrays;

public class InsertPosition {

    public static int[] searchInsert(int[] nums, int target) {
       //want to insert the target

        int start = 0;
        int end = nums.length,insert = 0,temp=0;
        int[] res = new  int[end+1];
        ArrayList<Integer> al = new ArrayList<>();
        while( start<end && target>nums[start])
            {
                start++;
                insert=start;

            }
        for(int i = 0;i<end;i++)
        {
            al.add(nums[i]);
        }
        al.add(insert,target);
        for(int j=0; j<al.size();j++)
        {
            res[j]=al.get(j);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 8, 9};

        System.out.println(Arrays.toString(searchInsert(nums, 10))); // 2
//        System.out.println(searchInsert(nums, 2)); // 1
//        System.out.println(searchInsert(nums, 7)); // 4
//        System.out.println(searchInsert(nums, 0)); // 0
    }
}
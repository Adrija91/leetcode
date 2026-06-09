import java.util.*;

public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length==0) {return null;}
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for(int i =0;i<n-3;i++)
        {
            if(i>0 && nums[i]==nums[i-1])
            {
                continue;
            }
            for(int j = i+1;j<n-1;j++)
            {
                if(j>i+1 && nums[j]==nums[j-1])
                {
                    continue;
                }
                int start = j+1, end = n-1;
                while(start<end)
                {
                    long sum = (long)nums[start]+nums[end]+nums[i]+nums[j];
                    res.add(Arrays.asList(nums[start],nums[end],nums[i],nums[j]));
                    end--;start++;
                    while(start<end && nums[start]==nums[start-1]){start++;}
                    while(start<end && nums[end]==nums[end+1]){end--;}
                    if(sum>target)
                    {
                        end--;
                    }
                    else
                    {
                        start++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;

        System.out.println(fourSum(nums1, target1));

        int[] nums2 = {2, 2, 2, 2, 2};
        int target2 = 8;

        System.out.println(fourSum(nums2, target2));
    }
}
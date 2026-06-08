//1. Return all pairs of indices
//
//Input:
//
//nums = [2, 7, 11, 15, 3, 6]
//target = 9
//
//Output:
//
//        [[0,1], [4,5]]


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class allPairOfIndices {
    public List<List<Integer>> allTwoSumPairs(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i = 0;i<nums.length;i++)
        {
            hmap.put(nums[i],i);
        }

        for(int i = 0;i<nums.length;i++)
        {
            int diff = target-nums[i];
            if(hmap.containsKey(diff) && hmap.get(diff)>i)
            {
                res.add(Arrays.asList(hmap.get(diff),i));
            }
        }
        return res;
    }
    public static void main(String[] args) {

        allPairOfIndices solution = new allPairOfIndices();

        int[] nums = {2, 7, 11, 15, 3, 6};
        int target = 9;

        List<List<Integer>> result = solution.allTwoSumPairs(nums, target);

        System.out.println(result);
    }
}

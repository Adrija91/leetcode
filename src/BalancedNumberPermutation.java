import java.util.*;

public class BalancedNumberPermutation {

    public static String countBalancedNumbers(int[] p) {
        int n = p.length;
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i = 0;i<n;i++)
        {
            hmap.put(p[i],i);
        }
        int curMin = Integer.MAX_VALUE;
        int curMax = -1;
        String ans = "";
        for(int i = 1;i<=n;i++)
        {
            int currPos = hmap.get(i);
            if(curMin>currPos)
            {
                curMin=currPos;
            }
            if(curMax<currPos)
            {
                curMax=currPos;
            }
            int bal = curMax-curMin+1;

            if(bal==i)
            {
                ans+="1";
            }
            else
            {
                ans+="0";
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] p = {5, 1, 4, 2, 3};

        String result = countBalancedNumbers(p);

        System.out.println(result); // 10011
    }
}
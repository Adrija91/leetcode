import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringKDistinct {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0 || s.length() == 0) return 0;
        HashMap<Character,Integer> hmap = new HashMap<>();
        int left = 0,longest = 0;
        for(int i = 0;i<s.length();i++)
        {
            if(hmap.containsKey(s.charAt(i)))
            {
                hmap.put(s.charAt(i),hmap.get(s.charAt(i))+1);
            }
            else
            {hmap.put(s.charAt(i),1);}
            while(hmap.size()>k)
            {
                char leftCar = s.charAt(left);
                hmap.put(leftCar,hmap.get(leftCar)-1);
                if (hmap.get(leftCar)==0)
                {
                    hmap.remove(leftCar);
                }
                left++;
            }
            longest=Math.max(longest,i-left+1);
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestSubstringKDistinct solution = new LongestSubstringKDistinct();

        String s = "eceba";
        int k = 2;

        int result = solution.lengthOfLongestSubstringKDistinct(s, k);

        System.out.println(result);
    }
}
import java.util.ArrayList;

public class LongestSubsWithoutRepeatingCharacter {
    public int lengthOfLongestSubstring(String s) {
        ArrayList<Character> al = new ArrayList<Character>();

        int count = 0;
        int longest = 0;

        for (char i : s.toCharArray()) {
            while(al.contains(i))
            {
                al.remove(0);
            }
            al.add(i);
            longest=Math.max(longest,al.size());
        }

        return longest;
    }
    public static void main(String[] args) {

        LongestSubsWithoutRepeatingCharacter obj = new LongestSubsWithoutRepeatingCharacter();

        String s = "xxxx";
        int res = obj.lengthOfLongestSubstring(s);

        System.out.println(res);
    }
}

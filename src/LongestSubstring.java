import java.util.HashSet;

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> hset = new HashSet<>();

        int left = 0;
        int longest = 0;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            while (hset.contains(c)) {
                hset.remove(s.charAt(left));
                left++;
            }

            hset.add(c);

            longest = Math.max(longest, i - left + 1);
        }

        return longest;
    }

    public static void main(String[] args) {

        LongestSubstring obj = new LongestSubstring();

        String s = "abcabcbb";

        int result = obj.lengthOfLongestSubstring(s);

        System.out.println("Longest substring length: " + result);
    }
}
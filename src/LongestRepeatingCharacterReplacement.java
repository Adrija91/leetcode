import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> freqMap = new HashMap<>();

        int left = 0;
        int maxFreq = 0;
        int longest = 0;

        for (int right = 0; right < s.length(); right++) {

            char rightChar = s.charAt(right);

            freqMap.put(
                    rightChar,
                    freqMap.getOrDefault(rightChar, 0) + 1
            );

            maxFreq = Math.max(
                    maxFreq,
                    freqMap.get(rightChar)
            );

            int window = right - left + 1;

            while (window - maxFreq > k) {

                char leftChar = s.charAt(left);

                freqMap.put(
                        leftChar,
                        freqMap.get(leftChar) - 1
                );

                left++;

                window = right - left + 1;
            }

            longest = Math.max(longest, window);
        }

        return longest;
    }
    public static void main(String[] args) {

        LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();

        String s = "AABABBA";
        int k = 1;

        int result = obj.characterReplacement(s, k);

        System.out.println(result);
    }
}

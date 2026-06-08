import java.util.HashMap;

public class CharacterReplacement {

    public static int characterReplacement(String s, int k) {

        HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();

        int maxFreq = 0;
        int res = 0;
        int i = 0;

        for (int j = 0; j < s.length(); j++) {

            Character c = s.charAt(j);

            if (!hmap.containsKey(c)) {
                hmap.put(c, 1);
            } else {
                hmap.put(c, hmap.get(c) + 1);
            }

            maxFreq = Math.max(maxFreq, hmap.get(c));

            while ((j - i + 1) - maxFreq > k) {

                char currC = s.charAt(i);

                hmap.put(currC, hmap.get(currC) - 1);

                i++;
            }

            res = Math.max(res, j - i + 1);
        }

        return res;
    }

    public static void main(String[] args) {

        String s = "AABABBA";
        int k = 1;

        int result = characterReplacement(s, k);

        System.out.println("Longest Length: " + result);
    }
}
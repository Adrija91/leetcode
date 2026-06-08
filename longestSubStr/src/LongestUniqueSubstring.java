import java.util.HashSet;

public class LongestUniqueSubstring {

    public String longestSubstring(String s) {

        String res = "";
        HashSet<Character> hset = new HashSet<>();
        int left = 0;
        int longest = 0;
        HashSet<String> longestH = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

                while (hset.contains(c)) {
                    hset.remove(s.charAt(left));
                    left++;
                }

                hset.add(c);


                if(hset.size()>=longest)
                {
                    longest=hset.size();
                    res=s.substring(left,i+1);
                }
            }
        return res               ;
    }

    public static void main(String[] args) {

        LongestUniqueSubstring solution = new LongestUniqueSubstring();

        String s = "abcabcbb";

        String result = solution.longestSubstring(s);

        System.out.println(result);
    }
}
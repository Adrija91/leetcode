import java.util.HashSet;

public class CountUniqueSubstrings {

    public int countSubstrings(String s) {

        HashSet<Character> hset = new HashSet<>();
        int count = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            while (hset.contains(s.charAt(i))) {
                hset.remove(s.charAt(start));
                start++;
            }
            hset.add(s.charAt(i));
            count += i - start + 1;
        }
        return count;
    }

    public static void main(String[] args) {

        CountUniqueSubstrings solution = new CountUniqueSubstrings();

        String s = "abc";

        int result = solution.countSubstrings(s);

        System.out.println(result);
    }
}
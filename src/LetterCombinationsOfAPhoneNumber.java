import java.util.*;

public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber sol = new LetterCombinationsOfAPhoneNumber();

        String digits = "23";
        List<String> result = sol.letterCombinations(digits);

        System.out.println(result);
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        dfs(digits, phoneMap, "", 0, result);

        return result;
    }

    private void dfs(String digits, Map<Character, String> phoneMap,
                     String path, int index, List<String> result) {

        if (index == digits.length()) {
            result.add(path);
            return;
        }

        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);

        for (char letter : letters.toCharArray()) {
            dfs(digits, phoneMap, path + letter, index + 1, result);
        }
    }
}
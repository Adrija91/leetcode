import java.io.*;
import java.util.*;

class ReverseASentence {

    static char[] reverseWords(char[] arr) {

        String str = new String(arr);

        StringBuilder sb = new StringBuilder();

        // reverse full string
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }

        ArrayList<String> list_str =
                new ArrayList<>(Arrays.asList(sb.toString().split(" ")));

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < list_str.size(); i++) {

            String word = list_str.get(i);

            // reverse each word back
            for (int j = word.length() - 1; j >= 0; j--) {
                result.append(word.charAt(j));
            }

            if (i < list_str.size() - 1) {
                result.append(" ");
            }
        }

        return result.toString().toCharArray();
    }

    public static void main(String[] args) {

        char[] arr = {
                'p', 'e', 'r', 'f', 'e', 'c', 't', ' ',
                'm', 'a', 'k', 'e', 's', ' ',
                'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'
        };

        char[] result = reverseWords(arr);

        for (char ch : result) {
            System.out.print(ch);
        }
    }
}
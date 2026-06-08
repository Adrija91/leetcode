public class ValidPallindrom {

    public boolean isPalindrome(String s) {

        s = s.replace(" ", "");
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]", "");

        char[] charrA = s.toCharArray();

        for (int i = 0, j = charrA.length - 1;
             i < charrA.length / 2;
             i++, j--) {

            if (charrA[i] != charrA[j]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        ValidPallindrom obj = new ValidPallindrom();

        String s = "A man, a plan, a canal: Panama";

        boolean result = obj.isPalindrome(s);

        System.out.println(result);
    }
}
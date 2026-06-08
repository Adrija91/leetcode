public class LongestPalindromeStr {

    public String longestPalindrome(String s)
    {
        if (s.length() == 0) return null;
        int start = 0; int longest = 0;
        for(int i = 0;i<s.length();i++)
        {
            int l1 = expandFromCenter(s,i,i);
            int l2 = expandFromCenter(s,i,i+1);
            int l3 = Math.max(l1,l2);
            if(l3>longest)
            {
                longest=l3;
                start = i - (l3-1)/2;
            }
        }
        return s.substring(start,start+longest);
    }

    private int expandFromCenter(String s, int left, int right) {
        if(s.length() == 0) return 0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
        {
            left--;
            right++;
        }
        return right - left -1;

    }
    public static void main(String[] args) {

        LongestPalindromeStr obj = new LongestPalindromeStr();

        String s = "a";

        System.out.println(obj.longestPalindrome(s));
    }
}

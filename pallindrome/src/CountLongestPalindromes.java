public class CountLongestPalindromes {

    public int countLongestPalindromes(String s) {
        if(s.length()==0) return 0;
        int start=0,longest = 0, count=0;
        for(int i = 0;i<s.length();i++)
        {
            int oddL = expand(s,i,i);
            int evnL = expand(s,i,i+1);
            int l3 = Math.max(oddL,evnL);
            if(l3>longest)
            {
                longest=l3;
                count=1;
            }
            else if(l3==longest){
                count++;
            }
        }

        return count;
    }
    public int expand(String s, int start, int end)
    {
        if (s.length() == 0) return 0;
        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end))
        {
            start--; end++;
        }
        return end - start -1;
    }

    public static void main(String[] args) {
        CountLongestPalindromes solution = new CountLongestPalindromes();

        String s = "babad";

        int result = solution.countLongestPalindromes(s);

        System.out.println(result);
    }
}
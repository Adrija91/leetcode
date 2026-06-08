import java.util.ArrayList;
import java.util.List;

public class allLongestPallindrome {
    public List<String> allLongestPalindromes(String s) {
        List<String> res = new ArrayList<>();
        if(s.length()==0)
            return null;

        int longest = 0, count=0;
        for(int i = 0;i<s.length();i++)
        {
            int oddL = expand(s,i,i);
            int evnL = expand(s,i,i+1);
            int l3 = Math.max(oddL,evnL);
            int start = i - (l3 - 1) / 2;

            if(l3>longest)
            {
                longest=l3;
                res.clear();
                res.add(s.substring(start, start + longest));
            }
            else if(l3==longest)
            { res.add(s.substring(start,start+longest));}
        }

        return res;
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

        allLongestPallindrome solution = new allLongestPallindrome();

        String s = "babad";

        List<String> result = solution.allLongestPalindromes(s);

        System.out.println(result);
    }
}

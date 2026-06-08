public class countPallindrom {
    public int countLongestPalindromes(String s) {
        if(s.length()==0) return 0;
        int start = 0;int longest = 0;
        int count = 0;
        for(int i = 0;i<s.length();i++)
        {
            count += expand(s,i,i);
            count += expand(s,i,i+1);
        }
        return count;
    }

    public int expand(String s, int start,int end)
    {
     int count = 0;
     while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end))
        {
            count++;
            start--;
            end++;
        }
        return count;
    }
    public static void main(String[] args) {

        countPallindrom solution = new countPallindrom();

        String s = "babad";

        int result = solution.countLongestPalindromes(s);

        System.out.println(result);
    }
}

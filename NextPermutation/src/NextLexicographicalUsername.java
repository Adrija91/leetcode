public class NextLexicographicalUsername {

    public String nextUsername(String username) {

       char[] ch = username.toCharArray();
       int n = username.length();
       int i = n-2;
       while(i>=0 && ch[i]>=ch[i+1])
       {
           i--;
       }
       if(i>=0)
       {
           int j = n-1;
           while(j>0 && ch[j]<=ch[i])
           {
               j--;
           }
           swap(ch,i,j);
       }
       else {return null;}
       reverse(ch,i+1,n-1);
       String res = "";
       for(char c:ch)
       {
           res+=c;
       }
       return res;
    }

    public void swap(char[] ch,int i,int j)
    {
        char temp = ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
    }
    public void reverse(char[] ch, int start, int end)
    {
        while(start<end)
        {
            swap(ch,start,end);
            start++;
            end--;
        }
    }
    public static void main(String[] args) {

        NextLexicographicalUsername solution = new NextLexicographicalUsername();

        String username = "abdc";

        String result = solution.nextUsername(username);

        System.out.println(result); // acbd
    }
}
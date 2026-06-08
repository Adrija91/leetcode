public class NextGreaterEmployeeID {

    public int nextGreaterElement(int n) {
        char[] ch = Integer.toString(n).toCharArray();
        int n_len = ch.length;
        int i = n_len-2;
        while(i>=0 && ch[i]>=ch[i+1])
        {
            i--;
        }
        if(i>=0)
        {
            int j = n_len-1;
            while(ch[j]<=ch[i])
            {
                j--;
            }
            swap(ch,i,j);
        }
        else {
            return -1;
        }

        reverse(ch,i+1,n_len-1);
        int num = Integer.parseInt(new String(ch));
        return num;
    }

    public void swap(char[] ch,int i, int j)
    {
        char temp = ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
    }
    public void reverse(char[] ch,int start, int end)
    {
        while(start<end)
        {
            swap(ch,start,end);
            start++;
            end--;
        }
    }
    public static void main(String[] args) {

        NextGreaterEmployeeID solution = new NextGreaterEmployeeID();

        int n = 218765;

        int result = solution.nextGreaterElement(n);

        System.out.println(result);
    }
}
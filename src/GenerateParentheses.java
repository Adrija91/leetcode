import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        GenerateParentheses.backtrack(res,"",0,0,n);
        return res;
    }

    public static void backtrack(List<String> res, String s, int open, int close, int n)
    {
        if(s.length()==2*n)
        {
            res.add(s);
            return;
        }
        if(open<n)
        {
            backtrack(res,s+"(",open+1,close,n);
        }
        if(close<open)
        {
            backtrack(res,s+")",open,close+1,n);
        }
    }
    public static void main(String[] args) {
        int n = 3;

        List<String> answer = generateParenthesis(n);

        System.out.println(answer);
    }
}
import java.util.LinkedList;
import java.util.Queue;

public class JumpGameVII {

    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if(s.charAt(n-1)=='1')
        {
            return false;
        }
        int farthest = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty())
        {
            int index = q.poll();
            int start = Math.max(index+minJump,farthest+1);
            int end = Math.min(index+maxJump,n-1);
            for(int i = start;i<=end;i++)
            {
                if(s.charAt(i)=='0') {
                    if (i == n - 1) {
                        return true;
                    }
                    q.offer(i);
                }
            }
            farthest=end;
        }
        return false;
    }

    public static void main(String[] args) {

        JumpGameVII obj = new JumpGameVII();

        String s1 = "011010";
        int minJump1 = 2;
        int maxJump1 = 3;

        System.out.println(obj.canReach(s1, minJump1, maxJump1));
        // true

        String s2 = "01101110";
        int minJump2 = 2;
        int maxJump2 = 3;

        System.out.println(obj.canReach(s2, minJump2, maxJump2));
        // false
    }
}
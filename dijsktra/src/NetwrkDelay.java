import java.util.*;

public class NetwrkDelay {
    class Edge
    {
        int to, weight;

        Edge(int to,int weight)
        {
            this.to=to;
            this.weight=weight;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        List<Edge>[] graph = new ArrayList[n+1];

        for(int i =0;i<=n;i++)
        {
            graph[i]=new ArrayList<>();
        }

        for(int[] time:times)
        {
            int from = time[0];
            int to = time[1];
            int weight = time[2];
            graph[from].add(new Edge(to,weight));
        }

        int[] dest = new int[n+1];
        Arrays.fill(dest,Integer.MAX_VALUE);
        dest[k]=0;

        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.offer(new int[]{k,0});

        while(!pq.isEmpty())
        {
            int[] current = pq.poll();
            int node = current[0];
            int currntDistance = current[1];
            if(currntDistance>dest[node])
            {
                continue;
            }

            for(Edge edge:graph[node])
            {
                int nextNode = edge.to;
                int newDist = currntDistance+edge.weight;
                if(newDist<nextNode)
                {
                    dest[nextNode]=newDist;
                    pq.offer(new int[]{nextNode,newDist});
                }
            }
        }
        int ans = 0;
        for(int i = 1;i<=n;i++)
        {
            if(dest[i] == Integer.MAX_VALUE)
            {
                ans = -1;
            }

            ans = Math.max(ans,dest[i]);
        }
        return ans;
    }

    public static void main(String[] args) {

        int[][] times = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };

        int n = 4;
        int k = 2;

        NetwrkDelay obj = new NetwrkDelay();

        int result = obj.networkDelayTime(times, n, k);

        System.out.println("Answer = " + result);
    }
}
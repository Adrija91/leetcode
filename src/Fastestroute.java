import java.util.*;

class Fastestroute {

    public int shortestPath(
            int n,
            int[][] roads,
            int source,
            int destination) {

        HashMap<Integer,List<int[]>> graph = new HashMap<>();
        int cheapest = 0;
        for(int i = 0;i<n;i++)
        {
            graph.put(i,new ArrayList<int[]>());
        }
        for(int road[]:roads)
        {
            int from = road[0];
            int to = road[1];
            int wt = road[2];
            graph.get(from).add(new int[]{to,wt});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int[] srcDist = new int[n];
        Arrays.fill(srcDist,Integer.MAX_VALUE);
        srcDist[source]=0;
        pq.offer(new int[]{source,0});

        while(!pq.isEmpty())
        {
            int[] curr = pq.poll();
            int src = curr[0];
            int wt = curr[1];
            for(int[] edge:graph.get(src))
            {
               int neighbor = edge[0];
               int edge_wt = edge[1];
               if(wt+edge_wt<srcDist[neighbor])
               {
                   srcDist[neighbor]=wt+edge_wt;
                   pq.offer(new int[]{neighbor,srcDist[neighbor]});
               }
            }
        }
        if (srcDist[destination] == Integer.MAX_VALUE) {
            return -1;
        }

        return srcDist[destination];

    }

    public static void main(String[] args) {

        int n = 4;

        int[][] roads = {
                {0, 1, 4},
                {0, 2, 2},
                {2, 1, 1},
                {1, 3, 5},
                {2, 3, 8}
        };

        Fastestroute sol = new Fastestroute();

        System.out.println(
                sol.shortestPath(
                        n,
                        roads,
                        0,
                        3
                )
        );
    }
}
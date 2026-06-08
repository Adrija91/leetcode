import java.util.Arrays;

public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] prices = new int[n];
        Arrays.fill(prices,Integer.MAX_VALUE);
        prices[src]=0;
        for(int i = 0;i<=k;i++)
        {
            int[] temp= prices.clone();
            for(int[] f:flights)
            {
                int u= f[0];
                int v=f[1];
                int cost = f[2];
                if(prices[u]!=Integer.MAX_VALUE && prices[u]+cost<temp[v])
                {
                    temp[v]=prices[u]+cost;
                }
            }
            prices=temp;
        }
       if(prices[dst]==Integer.MAX_VALUE)
       {
           return -1;
       }
       else
       {
           return prices[dst];
       }
    }

    public static void main(String[] args) {

        CheapestFlightsWithinKStops solution =
                new CheapestFlightsWithinKStops();

        int n = 3;

        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };

        int src = 0;
        int dst = 2;
        int k = 0;

        int result =
                solution.findCheapestPrice(n, flights, src, dst, k);

        System.out.println(result); // 700
    }
}
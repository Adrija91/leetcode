import java.util.Arrays;

public class CheapestRdNegative {

        public int cheapestCost(int n, int[][] roads, int source, int destination) {

            int[] dest = new int[n];
            int cheap = 0;

            Arrays.fill(dest,Integer.MAX_VALUE);
            dest[source] = 0;
            for(int i = 0;i<n-1;i++)
            {
                for(int[] rd:roads)
                {
                    int from = rd[0];
                    int to = rd[1];
                    int wt = rd[2];
                    if(dest[from]!=Integer.MAX_VALUE && dest[from]+wt<dest[to])
                    {
                        dest[to] = dest[from]+wt;
                    }
                }
            }
            if(dest[destination]!=Integer.MAX_VALUE)
            {
                cheap=dest[destination];
            }
            else {cheap=-1;}
            return cheap;
        }

        public static void main(String[] args) {

            int n = 4;

            int[][] roads = {
                    {0, 1, 4},
                    {0, 2, 5},
                    {1, 2, -3},
                    {2, 3, 4}
            };

            CheapestRdNegative sol = new CheapestRdNegative();

            System.out.println(
                    sol.cheapestCost(4, roads, 0, 3));
            };
        }



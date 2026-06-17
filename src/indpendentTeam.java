import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class independentTeam {

    public int countTeams(int n,
                          int[][] connections) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0;i<n;i++)
        {
            graph.put(i,new ArrayList<>());
        }
        for (int[] con:connections)
        {
            int con1 = con[0];
            int con2 = con[1];

            graph.get(con1).add(con2);
            graph.get(con2).add(con1);
        }
        boolean[] visited = new boolean[n];
        int teams = 0;
        for(int i = 0;i<n;i++)
        {
            if(!visited[i])
            {
                teams++;
                dfs(visited,i,graph);
            }
        }
        return teams;
    }

    private void dfs(boolean[] visited, int curr, HashMap<Integer, List<Integer>> graph) {
        visited[curr]=true;
        for(int neighbor:graph.get(curr))
        {
            if(!visited[neighbor])
            {
                dfs(visited,neighbor,graph);
            }
        }
    }

    public static void main(String[] args) {

        int n = 5;

        int[][] connections = {
                {0,1},
                {1,2},
                {3,4}
        };

        independentTeam sol = new independentTeam();

        System.out.println(
                sol.countTeams(
                        n,
                        connections
                )
        );
    }
}
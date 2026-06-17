public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for(int i = 0;i<n;i++) {
            if (!visited[i]) {
                provinces++;
                dfs(isConnected, visited, i,n);
            }
        }
        return provinces;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int row,int l) {
        visited[row]=true;
        for(int neighbor = 0;neighbor<l;neighbor++)
        {
            if((isConnected[row][neighbor]==1) && !visited[neighbor])
            {
                dfs(isConnected,visited,neighbor,l);
            }
        }
    }
    public static void main(String[] args) {

        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        NumberOfProvinces sol =
                new NumberOfProvinces();

        int answer =
                sol.findCircleNum(isConnected);

        System.out.println(
                "Number of Provinces = "
                        + answer);
    }

}

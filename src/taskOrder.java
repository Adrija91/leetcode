import java.util.*;

class taskOrder {

    public int[] taskOrder(
            int n,
            int[][] dependencies) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n];
        int[] res = new int[n];

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] depend:dependencies)
        {

                graph.get(depend[0]).add(depend[1]);
                indegree[depend[1]]++;

        }

        for(int i = 0;i<n;i++)
        {
            if(indegree[i]==0)
            {
                q.offer(i);
            }
        }

        int ind = 0;
        while(!q.isEmpty())
        {
            int currTask = q.poll();
            res[ind]=currTask;
            ind++;
            for(Integer preq:graph.get(currTask))
            {
                indegree[preq]--;
                if(indegree[preq]==0)
                {
                    q.offer(preq);
                }
            }
        }
        if(ind==n)
        {
            return res;
        }
        return new int[0];
    }
    public static void main(String[] args) {

        int n = 5;

        int[][] dependencies = {
                {0, 2},
                {1, 2},
                {2, 3},
                {3, 4}
        };

        taskOrder sol = new taskOrder();

        int[] result =
                sol.taskOrder(
                        n,
                        dependencies);

        System.out.println(
                Arrays.toString(result));
    }
}
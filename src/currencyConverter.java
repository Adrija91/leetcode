import java.util.*;
public class currencyConverter {
    public boolean canConvert(String[][] pairs, String source, String target) {

        int n = pairs.length;
        HashMap<String,ArrayList<String>> graph = new HashMap<>();
        HashSet<String> visited = new HashSet<>();
        for(String[] pair:pairs)
        {
            if(!graph.containsKey(pair[0]))
            {
                graph.put(pair[0],new ArrayList<>());
            }
            graph.get(pair[0]).add(pair[1]);

            if (!graph.containsKey(pair[1])) {
                graph.put(pair[1], new ArrayList<>());
            }
            graph.get(pair[1]).add(pair[0]);
        }
            boolean ans = dfs(graph,visited,source,target);
            return ans;
        }

    private boolean dfs(HashMap<String, ArrayList<String>> graph, HashSet<String> visited, String source, String target) {

        if (source.equals(target))
        {
            return true;
        }
        visited.add(source);
        for(String neighbor:graph.get(source))
        {
            if(!visited.contains(neighbor))
            {
                if(dfs(graph,visited,neighbor,target))
                {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {

        String[][] pairs = {
                {"USD", "EUR"},
                {"EUR", "INR"},
                {"INR", "JPY"},
                {"EUR", "USD"},
                {"EUR","KI"}
        };

        currencyConverter sol = new currencyConverter();

        boolean result =
                sol.canConvert(
                        pairs,
                        "INR",
                        "KI");

        System.out.println(result);
    }
    }

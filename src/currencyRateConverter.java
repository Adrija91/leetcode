import java.util.*;

public class currencyRateConverter {

    public double convert(String[][] pairs,
                          double[] rates,
                          String source,
                          String target) {

        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < pairs.length; i++) {
            String from = pairs[i][0];
            String to = pairs[i][1];
            double rate = rates[i];

            if (!graph.containsKey(from)) {
                graph.put(from, new HashMap<>());
            }

            if (!graph.containsKey(to)) {
                graph.put(to, new HashMap<>());
            }

            graph.get(from).put(to, rate);
            graph.get(to).put(from, 1.0 / rate);
        }

        HashSet<String> visited = new HashSet<>();

        return dfs(graph, visited, source, target, 1.0);
    }

    private double dfs(Map<String, Map<String, Double>> graph,
                       HashSet<String> visited,
                       String current,
                       String target,
                       double value) {

        if (current.equals(target)) {
            return value;
        }

        visited.add(current);

        if (!graph.containsKey(current)) {
            return -1.0;
        }

        for (String neighbor : graph.get(current).keySet()) {
            if (!visited.contains(neighbor)) {

                double rate = graph.get(current).get(neighbor);

                double result = dfs(
                        graph,
                        visited,
                        neighbor,
                        target,
                        value * rate
                );

                if (result != -1.0) {
                    return result;
                }
            }
        }

        return -1.0;
    }

    public static void main(String[] args) {

        String[][] pairs = {
                {"USD", "EUR"},
                {"EUR", "CAD"}
        };

        double[] rates = {
                10.0,
                2.0
        };

        currencyRateConverter cc = new currencyRateConverter();

        System.out.println(cc.convert(pairs, rates, "USD", "CAD")); // 20.0
        System.out.println(cc.convert(pairs, rates, "CAD", "USD")); // 0.05
        System.out.println(cc.convert(pairs, rates, "USD", "JPY")); // -1.0
    }
}
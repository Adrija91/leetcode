import java.util.*;

public class mergeInterval {

    public int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] nextInterval : intervals) {

            // Check overlap
            if (currentInterval[1] >= nextInterval[0]) {

                currentInterval[1] =
                        Math.max(currentInterval[1], nextInterval[1]);

            } else {

                currentInterval = nextInterval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {

        mergeInterval obj = new mergeInterval();

        int[][] intervals = {
                {4, 7},
                {1, 4},
                {2, 2},
                {10, 1},
                {56,78}
        };

        int[][] result = obj.merge(intervals);

        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
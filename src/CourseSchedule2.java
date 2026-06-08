import java.util.*;

public class CourseSchedule2 {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<Integer> alist = new ArrayList<>();
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indeg = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        Queue<Integer> q = new LinkedList<>();

        for (int[] preq : prerequisites) {
            int course = preq[0];
            int pre = preq[1];

            graph[pre].add(course);
            indeg[course]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            alist.add(curr);

            for (int nxtC : graph[curr]) {
                indeg[nxtC]--;

                if (indeg[nxtC] == 0) {
                    q.offer(nxtC);
                }
            }
        }

        if (alist.size() != numCourses) {
            return new int[0];
        }

        int[] res = new int[alist.size()];

        for (int i = 0; i < alist.size(); i++) {
            res[i] = alist.get(i);
        }

        return res;
    }

    public static void main(String[] args) {

        int numCourses = 4;

        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

        int[] result = findOrder(numCourses, prerequisites);

        System.out.println(Arrays.toString(result));
    }
}
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public static class courseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0;i<numCourses;i++)
        {
            graph[i] = new ArrayList<>();
        }

        for(int[] c:prerequisites) {
            int preReq = c[0];
            int course = c[1];
            graph[preReq].add(course);
            inDegree[course]++;
        }

        for(int i = 0;i<numCourses;i++)
        {
            if(inDegree[i]==0)
            {
                q.offer(i);
            }
        }

        int coursesTaken = 0;
        while(!q.isEmpty())
        {
            int currCourse = q.poll();
            coursesTaken++;

            for(int nextCourse:graph[currCourse])
            {
                inDegree[nextCourse]--;
                if(inDegree[nextCourse]==0)
                {
                    q.offer(nextCourse);
                }
            }
        }
        return coursesTaken==numCourses;
    }

}

public static void main(String[] args) {
    courseSchedule cs = new courseSchedule();

    int numCourses = 2;
    int[][] prerequisites = {{0, 1}};

    System.out.println(cs.canFinish(numCourses, prerequisites));
}


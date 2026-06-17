import java.util.LinkedList;
import java.util.Queue;

class orangesRotting {

    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // Find all rotten oranges
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {

                if(grid[r][c] == 2) {
                    q.offer(new int[]{r,c});
                }

                if(grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        if(fresh == 0) {
            return 0;
        }

        int minutes = 0;

        int[][] dirs = {
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}
        };

        while(!q.isEmpty()) {

            int size = q.size();

            for(int i = 0; i < size; i++) {

                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];

                for(int[] d : dirs) {

                    int nr = r + d[0];
                    int nc = c + d[1];

                    if(nr >= 0 &&
                            nc >= 0 &&
                            nr < rows &&
                            nc < cols &&
                            grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;
                        fresh--;

                        q.offer(new int[]{nr,nc});
                    }
                }
            }

            minutes++;

            if(fresh == 0) {
                return minutes;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        orangesRotting solution = new orangesRotting();

        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };

        int result = solution.orangesRotting(grid);

        System.out.println("Minutes = " + result);
    }
}
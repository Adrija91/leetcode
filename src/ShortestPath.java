import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class ShortestPath {
    public int shortestPath(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int moves = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 'S') {
                    q.offer(new int[]{i, j});
                    grid[i][j] = '1';
                }
            }
        }

        int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                int[] curPos = q.poll();
                int x = curPos[0];
                int y = curPos[1];

                for (int[] d : dir) {
                    int nx = x + d[0];
                    int ny = y + d[1];
                    if (nx < 0 || ny < 0 || nx >= row || ny >= col) {
                        continue;
                    }
                    if (grid[nx][ny] == '1') {
                        continue;
                    }
                    if (grid[nx][ny] == 'E') {
                        return moves + 1;
                    }
                    grid[nx][ny] = '1';
                    q.offer(new int[]{nx, ny});
                }
            }
            moves++;
        }

        return -1;
    }

    public static void main(String[] args) {

        char[][] grid = {
                {'S', '0', '0'},
                {'1', '1', '0'},
                {'0', '0', 'E'}
        };

        ShortestPath sp = new ShortestPath();

        int answer = sp.shortestPath(grid);

        System.out.println("Shortest Path = " + answer);
    }
}
import java.util.LinkedList;
import java.util.Queue;

public class IslandCounter {
    public int numIslands(char[][] grid) {
        int res = 0;
        if(grid==null || grid.length==0)
        {
            return -1;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

        for(int r = 0; r<row; r++)
        {
            for(int c = 0; c<col;c++)
            {
                if (grid[r][c]=='1')
                {
                    res++;

                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{r,c});
                    while(!q.isEmpty())
                    {
                        int[] curr = q.poll();
                        int currRow = curr[0];
                        int currCol = curr[1];

                        for(int[] dir:directions)
                        {
                            int nextRow=currRow + dir[0];
                            int nextCol=currCol + dir[1];

                            if(nextRow>=0 && nextCol>=0 && nextRow<row && nextCol<col && grid[nextRow][nextCol]=='1')
                            {
                                grid[nextRow][nextCol]='0';
                                q.offer(new int[]{nextRow,nextCol});
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        IslandCounter counter = new IslandCounter();

        char[][] grid = {
                {'0','1','1','1','0'},
                {'0','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        System.out.println("Total islands: " + counter.numIslands(grid)); // 🎉 Outputs: 3
    }
}
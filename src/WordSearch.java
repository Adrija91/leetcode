public class WordSearch {

    public boolean exist(char[][] board, String word) {

        int row = board.length;
        int col = board[0].length;
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                if(dfs(board,i,j,word,0))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board,int row,int col, String word, int index)
    {
        if(index==word.length())
        {
            return true;
        }
        if(row<0 || col<0 || row>=board.length || col>=board.length || board[row][col]!=word.charAt(index))
        {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '-';
        boolean found = dfs(board,row+1,col,word,index+1) || dfs(board,row,col+1,word,index+1) ||
                dfs(board,row-1,col,word,index+1) || dfs(board,row,col-1,word,index+1);

        board[row][col] = temp;
        return found;
    }

    public static void main(String[] args) {

        WordSearch ws = new WordSearch();

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println(ws.exist(board, "ABCCED")); // true
        System.out.println(ws.exist(board, "SEE"));    // true
        System.out.println(ws.exist(board, "ABCB"));   // false
    }
}
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        if(board == null || m == 0 || n == 0) {
            return;
        }
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                int count = getLive(board, i, j);
                if(board[i][j] == 0 && count == 3) {
                    board[i][j] = 3;
                }
                else if(board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 2;
                }
            }
        }
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                board[i][j] = board[i][j] % 2;
            }
        }
        return;
    }
    public int getLive(int[][] board, int i, int j) {
        int count = 0;
        for(int x = i - 1; x <= i + 1; x ++) {
            for(int y = j - 1; y <= j + 1; y ++) {
                if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || i == x && j == y) {
                    continue;
                }
                if(board[x][y] == 1 || board[x][y] == 2) {
                    count ++;
                }
            }
        }
        return count;
    }
}

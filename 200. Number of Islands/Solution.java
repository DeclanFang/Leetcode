class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int result = 0;
        for(int i = 0; i < grid.length; i ++) {
            for(int j = 0; j < grid[0].length; j ++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    result ++;
                    bfs(grid, visited, i, j);
                }
            }
        }
        return result;
    }
    public void bfs(char[][] grid, boolean[][] visited, int row, int column) {
        if(row >= 0 && row < grid.length && column >= 0 && column < grid[0].length && !visited[row][column] && grid[row][column] == '1') {
            visited[row][column] = true;
            bfs(grid, visited, row - 1, column);
            bfs(grid, visited, row, column - 1);
            bfs(grid, visited, row + 1, column);
            bfs(grid, visited, row, column + 1);
        }
    }
}

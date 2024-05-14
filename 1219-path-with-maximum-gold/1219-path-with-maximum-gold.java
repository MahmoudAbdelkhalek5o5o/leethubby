class Solution {
    int max = 0;
    public int getMaximumGold(int[][] grid) {
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]!=0){
                    boolean [][] isVisited = new boolean[grid.length][grid[0].length];
                    collect(i, j, grid, isVisited, grid[i][j]);
                }
            }
        }
        return max;
    }
    private void collect(int i, int j, int [][] grid, boolean [][] isVisited, int score){
        isVisited[i][j] = true;
        if((i==0 || isVisited[i-1][j] || grid[i-1][j]==0) && ((j==0 || isVisited[i][j-1]) || grid[i][j-1]==0) &&
                (i==grid.length-1 || isVisited[i+1][j] || grid[i+1][j]==0) && ((j==grid[0].length-1 || isVisited[i][j+1] || grid[i][j+1]==0))){
            if(score>max){
                max = score;
            }
        }
        if(i>0 && !isVisited[i-1][j] && grid[i-1][j]>0){
            collect(i-1, j, grid, isVisited, score + grid[i-1][j]);
        }
        if(i<grid.length-1 && !isVisited[i+1][j] && grid[i+1][j]>0){
            collect(i+1, j, grid, isVisited, score + grid[i+1][j]);
        }
        if(j>0 && !isVisited[i][j-1] && grid[i][j-1]>0){
            collect(i, j-1, grid, isVisited, score + grid[i][j-1]);
        }
        if(j<grid[0].length-1 && !isVisited[i][j+1] && grid[i][j+1]>0){
            collect(i, j+1, grid, isVisited, score + grid[i][j+1]);
        }
        isVisited[i][j] = false;
    }
}
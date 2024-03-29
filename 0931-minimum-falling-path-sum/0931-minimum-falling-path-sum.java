class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int [][] dp = new int [matrix.length][matrix[0].length];
        for(int i =0;i<matrix.length;i++){
            Arrays.fill(dp[i], 101);
        }
        int min = Integer.MAX_VALUE;
        for(int i =0;i<matrix[0].length;i++){
            int ans = solve(matrix, dp, 0, i);
            if(min>ans)min = ans;
        }
        return min;
    }
    private int solve(int [][] matrix, int [][] dp, int i, int j){
        if(i>=matrix.length || i<0 || j>=matrix[0].length || j<0)
            return Integer.MAX_VALUE;
        if(i == matrix.length-1){
            dp[i][j]=matrix[i][j];
            return dp[i][j];
        }
        if(dp[i][j]!=101){
            return dp[i][j];
        }
        dp[i][j]=Math.min(Math.min(solve(matrix,dp,i+1,j-1),solve(matrix,dp,i+1,j)), solve(matrix,dp,i+1,j+1))
            +matrix[i][j];
        return dp[i][j];
    }
}
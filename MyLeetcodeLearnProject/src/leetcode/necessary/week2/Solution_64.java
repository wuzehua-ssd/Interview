package leetcode.necessary.week2;

public class Solution_64 {
	public static void main(String[] args) {
		int [][] grid = {
				{1,3,1},
				{1,5,1},
				{4,2,1}
		};
		System.out.println(minPathSum(grid));
	}

	public static int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		
		//状态定义
		int [][] dp = new int[m][n];
		
		//状态初始化
		dp[0][0] = grid[0][0];
		for(int i = 1 ; i < m ; i++) {
			dp[i][0] = dp[i-1][0] + grid[i][0];
		}
		for(int j = 1 ; j < n ; j++) {
			dp[0][j] = dp[0][j-1] + grid[0][j];
		}
		
		//状态转移
		for(int i=1 ; i < m ;i++) {
			for(int j = 1 ; j < n ;j++) {
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
			}
		}
		
		return dp[m-1][n-1];
	}
}

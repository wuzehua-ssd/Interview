package leetcode.dp;

//爬楼梯问题：类似于青蛙跳台阶
public class Solution_73 {
	public static void main(String[] args) {
		int n = 3;
		System.out.println(climbStairs(n));
	}
	public static int climbStairs(int n) {
		//1、状态定义
		//dp[i]表示爬到第i+1层台阶有几种爬法
		int [] dp = new int [n];
		
		//2、状态初始化
		//第一层台阶有一种爬法，第二层台阶有两种爬法
		dp[0] = 1;
		dp[1] = 2;
		
		//3、状态转移方程
		//dp[i] = dp[i-1] + dp[i-2]
		for(int i = 2 ; i < n ; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n-1];
	}
}

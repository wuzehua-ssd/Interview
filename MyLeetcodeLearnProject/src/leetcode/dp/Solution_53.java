package leetcode.dp;

//最大子序和
public class Solution_53 {
	public static void main(String[] args) {
		int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}
	public static int maxSubArray(int [] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int max = 0;
		
		//1、状态定义
		//dp[i]表示前i个元素最大子序和
		int [] dp = new int[nums.length];
		
		//2、状态初始化
		//数组中第一个元素的最大和就是第一个元素值
		dp[0] = nums[0];
		max = nums[0];
		
		//3、状态转移：dp[i] = max(dp[i - 1], 0) + nums[i]
		for(int i = 1 ; i < nums.length ; i++) {
			dp[i] = Math.max(dp[i-1], 0) + nums[i];
			max = Math.max(max, dp[i]);
		}
		
		return max;
	}
}

package leetcode.dp;

//打家劫舍问题
public class Solution_198 {
	public static void main(String[] args) {
		int [] nums1 = {1,2,3,1};
		int [] nums2 = {2,7,9,3,1};
		System.out.println(rob(nums1));
		System.out.println(rob(nums2));
	}
	public static int rob(int [] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		//1、状态定义
		//dp[i]表示前i个房子能抢到最大钱数
		int [] dp = new int[nums.length];
		
		//2、状态初始化
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		
		//3、状态转移方程
		//dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1])
		for(int i = 2 ; i < nums.length ; i++) {
			dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
		}
		return dp[nums.length-1];
	}
}

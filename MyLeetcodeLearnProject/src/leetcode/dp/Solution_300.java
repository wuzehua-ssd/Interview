package leetcode.dp;

//最长上升子序列问题-字节面试
public class Solution_300 {
	public static void main(String[] args) {
		int [] nums = {10,9,2,5,3,7,101,18};
		System.out.println(lengthOfLIS(nums));
	}
	public static int lengthOfLIS(int [] nums) {
		if(nums.length <= 1) {
			return nums.length;
		}
		//声明dp数组用于保存前i个元素以nums[i]结尾的最长子序列
		int [] dp = new int[nums.length];
		dp[0] = 1; //初始化dp
		int maxans = 1; //用于保存最大的d[i]来返回最长子序列
		//对数组dp进行循环赋值
		for(int i = 1 ; i < dp.length ; i++) {
			int maxval = 0;//用于保存本次循环中前i-1个元素中结尾比nums[i]小的最长子序列
			for(int j = 0 ; j < i ; j++) {
				if(nums[j] < nums[i]) {
					maxval = Math.max(maxval, dp[j]); //更新前i个元素中比nums[i]小的最长子序列长度
				}
			}
			dp[i] = maxval + 1; //得到以当前位置结尾的最长子序列长度
			maxans = Math.max(maxans, dp[i]); //更新dp中最大值，即所求最长子序列长度
		}
		
		return maxans;
	}
}

package leetcode.dp;

public class Solution_303 {
	private static int [] sum; //用于保存前i个元素的总和
	public static void main(String[] args) {
		int [] nums = {-2, 0, 3, -5, 2, -1};
		NumArray(nums);
		System.out.println(sumRange(0, 2));
		System.out.println(sumRange(2, 5));
		System.out.println(sumRange(0, 5));
	}
	public static void NumArray(int[] nums) {
		sum = new int[nums.length+1];
		sum[0] = 0;
		for(int i = 0 ; i < nums.length ; i++) {
			sum[i+1] = sum[i] + nums[i];
		}
    }
    
    public static int sumRange(int i, int j) {
    	return sum[j+1] - sum[i];
    }
}

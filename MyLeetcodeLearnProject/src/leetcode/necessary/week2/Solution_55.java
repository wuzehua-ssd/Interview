package leetcode.necessary.week2;

public class Solution_55 {
	public static void main(String[] args) {
		int [] nums1 = {2,3,1,1,4};
		int [] nums2 = {3,2,1,0,4};
		System.out.println(canJump(nums1));
		System.out.println(canJump(nums2));
	}
	public static boolean canJump(int [] nums) {
		int n = nums.length;
        int rightmost = 0; //右边最远可达点
        for (int i = 0; i < n; ++i) { //进行遍历
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]); //更新右边最远可达点
                if (rightmost >= n - 1) { //如果右边最远可达点远于终点，返回true
                    return true;
                }
            }
        }
        return false;
	}
}

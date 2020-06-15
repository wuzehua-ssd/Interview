package leetcode.necessary.week1;

public class Solution_33 {
	public static void main(String[] args) {
		int [] nums = {4,5,6,7,0,1,2};
		int target = 0;
		System.out.println(search(nums, target));
	}
	public static int search(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return -1;
		}
		int start = 0;
		int end = nums.length-1;
		int mid;
		while(start <= end) {
			mid = start + (end - start) / 2;
			if(nums[mid] == target) {
				return mid;
			}
			//前半部分有序时
			if(nums[start] <= nums[mid]) {
				//target在前半部分时
				if(target >= nums[start] && target < nums[mid]) {
					end = mid-1;
				}else {
					start = mid+1;
				}
			}else {//后半部分有序时
				//target在后半部分时
				if(target <= nums[end] && target > nums[mid]) {
					start = mid + 1;
				}else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}
}

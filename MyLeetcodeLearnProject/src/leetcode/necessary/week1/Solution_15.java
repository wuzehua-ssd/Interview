package leetcode.necessary.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_15 {
	public static void main(String[] args) {
		int [] nums = {-1,0,1,2,-1,-4};
		System.out.println(threeSum(nums));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new ArrayList(); //用于保存结果
		int len = nums.length;
		if(nums == null || len < 3) {
			return ans;
		}
		Arrays.sort(nums);
		//System.out.println(Arrays.toString(nums));
		for(int i = 0 ; i < len ; i++) {
			if(nums[i] > 0) { //如果当前的nums[i]大于0，直接跳出循环
				break;
			}
			if(i > 0 && nums[i] == nums[i-1]) {
				continue; //与上一个元素相等，继续下一次循环去重
			}
			int l = i+1;
			int r = len-1;
			while(l<r) {
				int sum = nums[i]+nums[l]+nums[r];
				if(sum == 0) {
					ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
					while(l<r && nums[l] == nums[l+1]) {
						l++;//去重
					}
					while(l<r && nums[r] == nums[r-1]) {
						r--;//去重
					}
					l++;
					r--;
				}else if(sum > 0) {
					r--;
				}else if(sum < 0){
					l++;
				}
			}
		}
		return ans;
	}
}

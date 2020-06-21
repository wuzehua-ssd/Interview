package leetcode.necessary.day7;

import java.util.Arrays;

// leetcode第75题：颜色分类
public class Solution_75 {
	public static void main(String[] args) {
		int [] nums = {1,2,0};
		sortColors(nums);
		System.out.println(Arrays.toString(nums));
		
	}
	public static void sortColors(int [] nums) {
		int p0 = 0;
		int p2 = nums.length-1;
		int cur = 0;
		
		int temp = 0;
		while(cur <= p2) {
			if(nums[cur] == 0) {//交换p0和cur位置元素
				temp = nums[cur];
				nums[cur] = nums[p0];
				nums[p0] = temp;
				cur++;
				p0++;
			}else if(nums[cur] == 2){//交换cur和p2的值
				temp = nums[cur];
				nums[cur] = nums[p2];
				nums[p2] = temp;
				p2--;
			}else {//无交换发生，移动cur
				cur++;
			}
			
		}
	}
}


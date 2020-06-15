package leetcode.necessary.week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//两数之和问题

//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

//给定 nums = [2, 7, 11, 15], target = 9
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]

public class Solution_1 {
	public static void main(String[] args) {
		int [] nums = {2,7,11,15};
		int target = 9;
		System.out.println(Arrays.toString(twoSum(nums, target)));
	}
	//本题有暴力法、两遍哈希、一遍哈希等多种解法，本次采用一遍哈希
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(); //创建哈希表
		for(int i = 0 ; i < nums.length ; i++) { //遍历数组元素
			int temp = target - nums[i]; 
			if(map.containsKey(temp)) { //如果当前map中存放有目标值与当前数组元素得差值，直接返回结果
				return new int [] {map.get(temp),i};
			}
			map.put(nums[i], i); //没有则把当前nums[i]作为key，i作为value存入map
		}
		throw new IllegalArgumentException("No two sum solution!"); //没找到则抛出自定义异常
    }
}
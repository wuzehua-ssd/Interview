package leetcode.necessary.week2;

import java.util.ArrayList;
import java.util.List;

//全排列问题-回溯法构造解空间树求解
public class Solution_46 {
	public static void main(String[] args) {
		int [] nums = {1,2,3};
		System.out.println(permute(nums));
	}
	public static List<List<Integer>> permute(int [] nums){
		//创建集合保存最终输出结果
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		//调用回溯函数
		backTrack(0, list, nums);
		return list;
	}
	/**
	 * 回溯主方法，将叶子节点存入解集，非叶子节点利用元素交换方法得到全排列
	 * @param t 当前层数
	 * @param list 输出解集
	 * @param nums 源数字序列
	 */
	public static void backTrack(int t , List<List<Integer>> list , int [] nums) {
		//到达解空间树叶子节点时，将结果保存到输出集合中
		if (t == nums.length) {
			List<Integer> arr = new ArrayList<Integer>();
			for (int i = 0; i < nums.length; i++) {
				arr.add(nums[i]);
			}
			list.add(arr);
		} else { // 未到达叶子节点时
			for (int i = t; i < nums.length; i++) {
				// 将x[t] 和其之后的元素依次进行交换
				swap(nums, i, t);
				// 递归对下一层进行回溯
				backTrack(t + 1, list, nums);
				// 交换后的元素再换回来保持原始状态
				swap(nums, i, t);
			}
		}
	}
	public static void swap(int [] nums , int i , int t) {
		int temp = nums[i];
		nums[i] = nums[t];
		nums[t] = temp;
	}
}

package leetcode.necessary.day7;

import java.util.ArrayList;
import java.util.List;

public class Solution_78 {
	static List<List<Integer>> output = new ArrayList();
	static int n, k;

	public static void main(String[] args) {
		int [] nums = {1,2,3};
		subsets(nums);
		System.out.println(output);
	}
	
	public static List<List<Integer>> subsets(int[] nums) {
		n = nums.length;
		for (k = 0; k < n + 1; ++k) {
			backtrack(0, new ArrayList<Integer>(), nums);
		}
		return output;
	}
	
	public static void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
	    // 如果达到指定元素个数
	    if (curr.size() == k)
	      output.add(new ArrayList(curr));
	    for (int i = first; i < n; ++i) {
	      // 将当前i位置元素加入集合
	      curr.add(nums[i]);
	      // 从下一个位置开始回溯
	      backtrack(i + 1, curr, nums);
	      // backtrack
	      curr.remove(curr.size() - 1);
	    }
	  }

}

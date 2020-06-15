package leetcode.necessary.week1;

import java.util.Arrays;

public class Solution_31 {
	public static void main(String[] args) {
		int [] nums = {1,2,3};
		nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
	public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--; //找到i-1的点使得nums[i-1] > nums[i]
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--; //找到右边数组第一个比nums[i]大的点
            }
            swap(nums, i, j); //交换两者位置
        }
        reverse(nums, i + 1); //将后面的递减序列转换为递增数列
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

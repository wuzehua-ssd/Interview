package leetcode.necessary.day7;

import java.util.Arrays;
import java.util.Stack;

public class Solution_84 {
	public static void main(String[] args) {
		int [] heights = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(heights));
	}
	public static int largestRectangleArea(int[] heights) {
		int n = heights.length;
        int[] left = new int[n]; //确定最大矩形左边界
        int[] right = new int[n]; //确定最大矩形右边界
        Arrays.fill(right, n);
        
        Stack<Integer> mono_stack = new Stack<Integer>(); //单调栈声明
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) { //数组不为空且当前柱子高度小于栈顶时
                right[mono_stack.peek()] = i; //得出右边界
                mono_stack.pop(); //弹出栈顶元素
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek()); //左边界
            mono_stack.push(i); //入栈
        }
        
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]); //更新最大矩形大小
        }
        return ans;
    }
}

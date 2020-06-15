package leetcode.necessary.week1;

public class Solution_11 {
	public static void main(String[] args) {
		int [] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(height));
	}
	public static int maxArea(int[] height) {
		int maxarea = 0; //用于保存最大盛雨水量
		int start = 0; //头指针
		int end = height.length-1; //尾指针
		while(start < end) {
			maxarea = Math.max(maxarea, Math.min(height[start], height[end])* (end - start)); //更新最大盛雨水量
			if(height[start] <= height[end]) { //移动更矮的一边
				start++;
			}else {
				end--;
			}
		}
		return maxarea;
    }
}

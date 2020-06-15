package leetcode.necessary.week1;

import java.util.Stack;

public class Solution_32 {
	public static void main(String[] args) {
		String s =  ")()())";
		System.out.println(longestValidParentheses(s));
	}
	public static int longestValidParentheses(String s) {
		 int maxans = 0; //创建变量用于保存最大长度
	     Stack<Integer> stack = new Stack<>(); //创建栈
	     stack.push(-1); //先将-1压入栈中
	     for (int i = 0; i < s.length(); i++) {
	        if (s.charAt(i) == '(') { //对于遇到的'('，将其下标放入栈中
	            stack.push(i);
	        } else {
	            stack.pop(); //遇到')'，则将栈顶元素出栈
	            if (stack.empty()) { //如果栈为空，则把当前元素下标存入栈中
	                stack.push(i);
	            } else {
	                maxans = Math.max(maxans, i - stack.peek()); //更新最大长度
	            }
	        }
	     }
	     return maxans;
    }
}

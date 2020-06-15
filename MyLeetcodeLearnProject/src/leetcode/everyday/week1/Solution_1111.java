package leetcode.everyday.week1;

import java.util.Arrays;

//有效括号的嵌套深度
public class Solution_1111 {
	public static void main(String[] args) {
		String seq = "()(())()";
		System.out.println(Arrays.toString(maxDepthAfterSplit(seq)));
	}
	public static int[] maxDepthAfterSplit(String seq) {
		int flag = 0;
		int [] result = new int[seq.length()];
		
		for(int i = 0 ; i<seq.length() ; i++) {
			char c = seq.charAt(i);
			if('(' == c) {
				flag += 1;
				result[i] = (flag+1)%2;
			}
			if(')' == c) {
				result[i] = (flag+1) %2  ;
				flag -= 1;
			}
		}
		
		return result;
	}
}

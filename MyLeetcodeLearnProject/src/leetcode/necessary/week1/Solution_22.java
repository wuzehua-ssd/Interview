package leetcode.necessary.week1;

import java.util.ArrayList;
import java.util.List;

public class Solution_22 {
	public static void main(String[] args) {
		int n = 3;
		System.out.println(generateParenthesis(3));
	}

	public static List<String> generateParenthesis(int n) {
		List<String> ans = new ArrayList<String>();
		backtrack(ans, "", 0, 0, n);
		return ans;
	}
	//回溯函数，通过该函数生成所有可能结果并将其存入结果列表中
	public static void backtrack(List<String> ans, String cur, int open, int close, int max) {
		if(cur.length() == max*2) {
			ans.add(cur);
			return ; 
		}
		if(open < max) {
			backtrack(ans, cur+"(", open+1, close, max);
		}
		if(close < open) {
			backtrack(ans, cur+")", open, close+1, max);
		}
	}

	
}

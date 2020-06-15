package leetcode.necessary.week1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_17 {
	static Map<String,String> phone = new HashMap<String, String>(){{
			put("2", "abc");
			put("3", "def");
			put("4", "ghi");
			put("5", "jkl");
			put("6", "mno");
			put("7", "pqrs");
			put("8", "tuv");
			put("9", "wxyz");
		}
	};
	static List<String> output = new ArrayList<String>();
	public static void main(String[] args) {
		String digits = "23";
		letterCombinations(digits);
		System.out.println(output);
	}

	/**
	 * 回溯函数
	 * @param combination 当前产生组合
	 * @param next_digits 下一个输入的数字
	 */
	public static void backtrack(String combination,String next_digits) {
		if(next_digits.length() == 0) { //下一个数字为空，存储当前组合
			output.add(combination);
		}else {
			String digit = next_digits.substring(0,1); //得到下一个数字
			String letters = phone.get(digit); //得到下一个数字对应的字符
			for(int i = 0; i < letters.length() ; i++) { //遍历得到所有组合结果并进行下一次回溯
				String letter = phone.get(digit).substring(i, i + 1);
				 backtrack(combination + letter, next_digits.substring(1));
			}
		}
		
	}
	
	public static List<String> letterCombinations(String digits) {
		 if (digits.length() != 0)
		      backtrack("", digits); //初次回溯入口
		 return output;
	}
}

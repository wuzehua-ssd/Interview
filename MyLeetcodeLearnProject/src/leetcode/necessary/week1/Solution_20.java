package leetcode.necessary.week1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution_20 {
	static Map<Character, Character> map = new HashMap<Character, Character>();
	public static void main(String[] args) {
		 map.put(')', '(');
		 map.put(']', '[');
		 map.put('}', '{');
		 String string = "()[]{}";
		 System.out.println(isValid(string));
	}
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>(); //创建栈用于存取字符
		
		for(int i = 0 ; i < s.length() ; i++) { //遍历字符串s中
			char c = s.charAt(i); //取出当前字符
			if(map.containsKey(c)) { //如果当前字符是右括号中的一个，将栈顶元素取出与其对应左括号对比
				char temp = stack.isEmpty() ? '#' : stack.pop();
				if(temp != map.get(c)) { //如果不匹配，返回false
					return false;
				}
			}else {
				stack.push(c); //如果是左括号，将其压入栈中
			}
		}
		return stack.isEmpty(); //返回栈是否为空，为空说明匹配成功
	}
}

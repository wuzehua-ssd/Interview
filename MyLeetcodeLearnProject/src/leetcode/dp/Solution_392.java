package leetcode.dp;

public class Solution_392 {
	public static void main(String[] args) {
		String s1 = "abc";
		String t1 = "ahnbdc";
		String s2 = "acd";
		String t2 = "ahnbdc";
	}
	public static boolean isSubsequence(String s, String t) {
		char [] c = s.toCharArray(); //将字符串s转化成数组
		int j = -1;
		for(int i = 0 ; i < s.length() ; i++) {
			j = t.indexOf(c[i], j+1); //判断当前位置往后是否有字符char[i]
			if(j == -1) {
				return false; //没有返回false
			}
		}
		return true;
    }
}

package leetcode.dp;


//最长回文字符串
public class Solution_5 {
	public static void main(String[] args) {
		String s = "babad";
		System.out.println(longestPalindrome(s));
	}
	public static String longestPalindrome(String s) {
		if(s == null || s.length() < 2) {
			return s;
		}
		int strLen = s.length();
		int maxStart = 0; //最长回文字符串开始下标
		int maxEnd = 0; //最长回文字符串结束下标
		int maxLen = 1; //初始化最长回文字符串长度为1
		
		boolean [][] dp = new boolean[strLen][strLen]; //创建dp，数组：表示第l到第r位置是否为回文
		
		//下面进行初始化操作
		for(int r = 1 ; r < strLen ; r++) {
			for(int l = 0 ; l < r ; l++) {
				if((s.charAt(l) == s.charAt(r))&&((r-l <= 2) || (dp[l+1][r-1] == true) )) {
					dp[l][r] = true;
					//如果该回文长度大于目前保存最大回文长度就进行更新
					if((r-l+1) > maxLen) {
						maxLen = r-l+1;
						maxStart = l;
						maxEnd = r;
					}
				}
			}
		}
		return s.substring(maxStart, maxEnd + 1);
	}
}

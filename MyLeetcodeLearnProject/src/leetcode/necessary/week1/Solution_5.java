package leetcode.necessary.week1;

public class Solution_5 {
	public static void main(String[] args) {
		String s1 = "babad";
		System.out.println(longestPalindrome(s1));
		String s2 = "cbbd";
		System.out.println(longestPalindrome(s2));
	}
	public static String longestPalindrome(String s) {
		if(s == null || s.equals("")) {
            return s;
        }

        int len = s.length();
        char[] chars = s.toCharArray();

        //状态定义
        boolean[][] dp = new boolean[len][len];
        
        // 1字母初始化
        for(int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        // 2字母初始化 P(i,i+1)=(Si==Si+1)
        for(int i = 0; i < len - 1; i++) {
            dp[i][i+1] = (chars[i] == chars[i+1]);
        }

        int left = 0;
        int right = 0;
        int max = 1;
        for(int i = len - 2; i >= 0; i--) {
            for(int j = i + 1; j < len; j++) {
                // P(i,j)=(P(i+1,j−1) and Si==Sj)
                if(j != i+1) {
                    dp[i][j] = dp[i+1][j-1] && chars[i] == chars[j];
                }
                if(dp[i][j] && max < j - i + 1) {
                    max = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right+1);
	}
}

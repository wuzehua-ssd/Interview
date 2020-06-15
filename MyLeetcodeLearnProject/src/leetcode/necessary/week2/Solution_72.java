package leetcode.necessary.week2;

public class Solution_72 {
	public static void main(String[] args) {
		String word1 = "intention";
		String word2 = "execution";
		System.out.println(minDistance(word1, word2));
	}
	public static int minDistance(String word1, String word2) {
		int m = word1.length();
	    int n = word2.length();

	    // 有一个字符串为空串
	    if (n * m == 0)
	      return n + m;

	    // DP 数组
	    int [][] D = new int[m + 1][n + 1];

	    // 边界状态初始化
	    for (int i = 0; i < m + 1; i++) {
	      D[i][0] = i;
	    }
	    for (int j = 0; j < n + 1; j++) {
	      D[0][j] = j;
	    }

	    // 计算所有 DP 值
	    for (int i = 1; i < m + 1; i++) {
	      for (int j = 1; j < n + 1; j++) {
	        int left = D[i - 1][j] + 1;
	        int down = D[i][j - 1] + 1;
	        int left_down = D[i - 1][j - 1];
	        if (word1.charAt(i - 1) != word2.charAt(j - 1))
	          left_down += 1;
	        D[i][j] = Math.min(left, Math.min(down, left_down));

	      }
	    }
	    return D[m][n];
	}
}

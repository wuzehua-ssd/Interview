package leetcode.necessary.day7;

public class Solution_79 {
	static boolean[][] marked ;
	static int[][] direction = {{-1,0},{0,-1},{0,1},{1,0}};//用于移动搜索方向
	static int m; //行数
	static int n; //列数
	
	
	public static void main(String[] args) {
		char[][] board = {
				{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
		        };
		String string1 = "ABCCED";
		String string2 = "SEE";
		String string3 = "ABCB";
		System.out.println(exist(board, string1));
		System.out.println(exist(board, string2));
		System.out.println(exist(board, string3));
	}
	public static boolean exist(char[][] board, String word) {
		m = board.length;
		if(m == 0) {
			return false;
		}
		n = board[0].length;
		marked = new boolean[m][n]; //marked初始化
		
		for(int i = 0 ; i < m ; i++) {
			for(int j = 0 ; j < n ;j++) {
				if(dfs(i, j, 0, board, word)) { //使用深度优先搜索
					return true;
				}
			}
		}
		return false;
    }
	
	public static boolean dfs(int i,int j,int start,char[][] board,String word) {
		if(start == word.length() -1) {
			return board[i][j] == word.charAt(start); 
		}
		if(board[i][j] == word.charAt(start)) {
			marked[i][j] = true;
			for(int k = 0 ; k < 4 ; k++) { //遍历上下左右四个方向进行深度优先搜索
				int newX = i + direction[k][0];
				int newY = j + direction[k][1];
				if(inArea(newX, newY) && !marked[newX][newY]) {
					if(dfs(newX, newY, start+1, board, word)) {
						return true;
					}
				}
			}
			marked[i][j] = false;
		}
		return false;
	}
	
	public static boolean inArea(int x, int y) { //判断是否在边界内
		return x >= 0 && x < m && y >= 0 && y < n;
	}
}

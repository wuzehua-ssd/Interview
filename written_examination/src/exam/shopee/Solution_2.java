package exam.shopee;

import java.util.Scanner;

//矩阵最长递增路径
public class Solution_2 {
	static int max = 1;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String totalString = scanner.next();
		String[] totalStrings = totalString.split(",");
		//行数
		int m = Integer.valueOf(totalStrings[0]);
		//列数
		int n = Integer.valueOf(totalStrings[1]);
		if(m > 0 && n > 0) {
			//矩阵创建
			int[][] nums = new int[m][n];
			//矩阵初始化
			for(int i = 0 ; i < m ; i++) {
				String string = scanner.next();
				String[] strings = string.split(",");
				for(int j = 0 ; j < n ; j++) {
					nums[i][j] = Integer.valueOf(strings[j]);
				}
			}
			System.out.println(updataMax(nums, m, n));
		}else {
			System.out.println(0);
		}
		
	}
	//更新最长路径大小
	public static int updataMax(int[][] nums,int m,int n) {
		for(int i = 0 ; i < m ; i++) {
			for(int j = 0 ; j < n ; j++) {
				int[][] visited = new int[m][n];
				visited[i][j] = 1;
				getMax(nums, i, j,1,visited);
			}
		}
		return max;
	}
	public static void getMax(int[][] nums,int i,int j,int path,int [][] visited) {
		if((i-1 >= 0) && nums[i-1][j] > nums[i][j] && visited[i-1][j] == 0) {
			visited[i-1][j] = 1;
			getMax(nums, i-1, j,path+1,visited);
		}
		if ((j-1 >= 0) && nums[i][j-1] > nums[i][j] && visited[i][j-1] == 0) {
			visited[i][j-1] = 1;
			getMax(nums, i, j-1,path+1,visited);
		}
		if((i+1 < nums.length) && nums[i+1][j] > nums[i][j] && visited[i+1][j] == 0) {
			visited[i+1][j] = 1;
			getMax(nums, i+1, j,path+1,visited);
		}
		if((j+1 < nums[0].length) && nums[i][j+1] > nums[i][j] && visited[i][j+1] == 0) {
			visited[i][j+1] = 1;
			getMax(nums, i, j+1, path+1,visited);
		}
		max = Math.max(max, path);
	}
}

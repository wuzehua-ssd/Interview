package leetcode.necessary.week2;

import java.util.Arrays;

//旋转图像问题-48题
public class Solution_48 {
	public static void main(String[] args) {
		int[][] matrix = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		rotate(matrix);
		System.out.println(Arrays.deepToString(matrix));
	}
	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		//先进行上下翻转
		for (int i = 0; i < n / 2; i ++){
            int[] tmp = matrix[i];
            matrix[i] = matrix[n - i - 1];
            matrix[n - i - 1] = tmp;
        }
        //再对角翻转
        for (int i = 0; i < n; i ++){
            for (int j= i + 1; j < n; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}

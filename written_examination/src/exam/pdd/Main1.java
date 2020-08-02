package exam.pdd;

import java.util.Arrays;
import java.util.Scanner;
//8.2:多多的飞行棋
public class Main1 {
	public static int[] result = new int[3];
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int k = scanner.nextInt();
			int n = scanner.nextInt();
			int[] data = new int[n];
			for(int i = 0 ; i < n ; i++) {
				data[i] = scanner.nextInt();
			}
			//测试数据读入结果
			//System.out.println(Arrays.toString(data));
			getResult(k, n, data, 0);
			if(result[0] == 1) {
				System.out.println("paradox");
			}else if(result[0] == 0) {
				System.out.println(result[1] + " " + "0");
			}else {
				System.out.println(result[1] + " " + result[2]);
			}
		}
	}
	
	public static void getResult(int sum , int n , int[] data, int start) {
		if(n > start) {
			if(sum == data[start]) {
				result[0] = 1;
				return;
			}else if(sum < data[start]) {
				result[0] = -1;
				result[1] = sum;
				result[2] = n-start;
				return;
			}else {
				sum = sum - data[start];
				start++;
				getResult(sum, n, data, start);
			}
		}else {
			result[0] = 0;
			result[1] = sum;
			return;
		}
		
	}
}

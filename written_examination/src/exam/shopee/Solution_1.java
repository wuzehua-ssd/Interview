package exam.shopee;

import java.util.Scanner;

//跳台阶
public class Solution_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		System.out.println(nums(num));
	}
	public static int nums(int num) {
		if(num <= 2) {
			return num;
		}
		return nums(num-1)+nums(num-2);
	}
}

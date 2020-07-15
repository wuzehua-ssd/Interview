package exam.shopee;

import java.util.Scanner;

public class Solution_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		if(n<=0) {
			System.out.println(0);
		}else {
			String str = scanner.next();
			String[] strs = str.split(",");
			reSort(strs);
			String result = new String();
			for(int i = 0 ; i < n ; i++) {
				result = result+strs[i];
			}
			System.out.println(result);
		}
	}
	public static void reSort(String[] strs) {
		if(strs.length == 1) {
			return;
		}
		for(int i = 0 ; i < strs.length-1 ; i++) {
			for(int j = i + 1 ; j < strs.length ; j++) {
				int first = Integer.valueOf(strs[i]+strs[j]);
				int last = Integer.valueOf(strs[j]+strs[i]);
				if(first < last) {
					String tempString = strs[i];
					strs[i] = strs[j];
					strs[j] = tempString;	
				}
			}
		}
	}
}

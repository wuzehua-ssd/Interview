package exam.jd;

import java.util.Scanner;
public class Main2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int count = getNum(n, m);
			System.out.println(count);
		}
	}
	public static int getNum(int n , int m) {
		int count = 0;
		for(int i = n ; i <= m ; i++) {
			String stringNum = Integer.toString(i);
			boolean flag = false;
			if(stringNum.length()==1) {
				if(isNum(stringNum)&&isHW(stringNum)) {
					flag = true;
				}
			}else if(stringNum.length()==2) {
				String string1 = stringNum.substring(0,1);
				if(isNum(string1)&&isHW(string1)) {
					flag = true;
				}
				String string2 = stringNum.substring(1);
				if(isNum(string2)&&isHW(string2)) {
					flag = true;
				}
			}else {
				String startString = stringNum.substring(1);
				if(isNum(startString) && isHW(startString)) {
					flag = true;
				}
				for(int j = 1 ; j < stringNum.length()-1 ; j++) {
					String patternString = stringNum.substring(0,j) + stringNum.substring(j+1);
					if(isNum(patternString) && isHW(patternString)) {
						flag = true;
					}
				}
				String endString = stringNum.substring(0,stringNum.length()-1);
				if(isNum(endString) && isHW(endString)) {
					flag = true;
				}
			}
			if(flag) {
				count++;
			}
		}
		return count;
	}
	public static boolean isNum(String string) {
		int num = Integer.parseInt(string);
		for(int i = 2 ; i < num ; i++) {
			if(num%2 == 0) {
				return false;
			}
		}
		return true;
	}
	public static boolean isHW(String string) {
		char[] chars = string.toCharArray();
		int start = 0;
		int end = chars.length-1;
		while(start < end) {
			if(chars[start] == chars[end]) {
				start++;
				end--;
			}else {
				return false;
			}
		}
		return true;
	}
}

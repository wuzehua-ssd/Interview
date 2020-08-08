package exam.jd;

import java.util.Scanner;
public class Main1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			double result = getResult(n);
			System.out.println(String.format("%.4f", result));
			
		}
	}
	public static double getResult(int n) {
		if(n <= 0) {
			return 0.0000;
		}else {
			double result = 0.0000;
			for(int i = 1 ; i < n+1 ; i++) {
				result = result + 1.0/(5*(2*i-1))-1.0/(5*2*i);
			}
			return result;
		}
	}
}

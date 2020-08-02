package exam.yuanfudao;
import java.io.*;
import java.util.Arrays;
import java.util.Stack;
/*
 * 一心多用上课问题
 */
public class Main1 {
	public static void main(String[] args) throws IOException{
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		String string;
		while((string=bReader.readLine()) != null) {
			int n = Integer.parseInt(string);
			int [][] data = new int[n][2];
			if(n <= 0) {
				System.out.println(0);
			}else if(n==1) {
				System.out.println(1);
			}else {
				for(int i = 0 ; i < n ; i++) {
					String[] strings = bReader.readLine().split(" ");
					data[i][0] = Integer.parseInt(strings[0]);
					data[i][1] = Integer.parseInt(strings[1]);
				}
			}
			System.out.println(getK(data,n));
		}
	}
	
	//辅助函数，计算k:栈
	public static int getK(int[][] data,int n) {
		Stack<Integer> temp = new Stack<Integer>();
		temp.push(data[0][0]);
		temp.push(data[0][1]);
		int count = 1;
		int max = 1;
		for(int i = 1 ; i < n ; i++) {
			while(!temp.isEmpty() && temp.peek() >= data[i][0]) {
				temp.pop();
			}
			temp.push(data[i][0]);
			temp.push(data[i][1]);
			
		}
		return count;
	}
}

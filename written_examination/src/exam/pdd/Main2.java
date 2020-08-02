package exam.pdd;

import java.util.ArrayList;
import java.util.Scanner;
//8.2:多多的骰子组合
public class Main2 {
	public static ArrayList<ArrayList<Integer>> result;
	public static int[] resultNum;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			int[][] data = new int[n][6];
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < 6 ; j++) {
					data[i][j] = scanner.nextInt();
				}
			}
			getResult(data);
			System.out.println(result.size());
			for(int i = 0 ; i < resultNum.length ; i++) {
				System.out.print(resultNum[i] + " ");
			}
		}
	}
	public static void getResult(int[][] data) {
		result = new ArrayList<ArrayList<Integer>>();
		resultNum = new int[data.length];
		for(int i = 0 ; i < data.length ; i++) {
			if(result.isEmpty()) {
				ArrayList<Integer> path = new ArrayList<Integer>();
				for(int j = 0 ; j < 6 ; j++) {
					path.add(data[i][j]);
				}
				result.add(path);
				resultNum[0] = 1;
			}else {
				boolean flag = true;
				for(int x = 0 ; x < result.size() ; i++) {
					int n1 = result.get(x).get(0)+result.get(x).get(1) - data[i][0] - data[i][1];
					int n2 = result.get(x).get(2)+result.get(x).get(3) - data[i][2] - data[i][3];
					int n3 = result.get(x).get(4)+result.get(x).get(5) - data[i][4] - data[i][5];
					if((n1!=n2)&(n2!=n3)&(n3!=n1)) {
						flag = false;
						resultNum[x] = resultNum[x] + 1;
						break;
					}
				}
				ArrayList<Integer> path = new ArrayList<Integer>();
				for(int j = 0 ; j < 6 ; j++) {
					path.add(data[i][j]);
				}
				result.add(path);
				resultNum[result.size()-1] = 1;
			}
		}
	}
}

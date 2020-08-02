package exam.pdd;

import java.util.Scanner;
//8.2:多多吃饭
public class Main3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int dNum = scanner.nextInt();
			int nNum = scanner.nextInt();
			int t = scanner.nextInt();
			int[][] dData = new int[dNum][2];
			int[][] nData = new int[nNum][2];
			int minval = 0;
			int maxT = 0;
			boolean flag = false;
			for(int i = 0 ; i < dNum ; i++) {
				dData[i][0] = scanner.nextInt();
				dData[i][1] = scanner.nextInt();
			}
			for(int j = 0 ; j < nNum ; j++) {
				nData[j][0] = scanner.nextInt();
				nData[j][1] = scanner.nextInt();
			}
			for(int x = 0 ; x < dNum ; x++) {
				for(int y = 0 ; y < nNum ; y++) {
					maxT = Math.max(maxT, dData[x][1] + nData[y][1]);
					if(dData[x][1] + nData[y][1] >= t) {
						if(flag) {
							minval = Math.min(minval, dData[x][0]+nData[y][0]);
						}else {
							minval = dData[x][0]+nData[y][0];
							flag = true;
						}
						
					}
				}
			}
			for (int x1 = 0; x1 < dData.length; x1++) {
				if(dData[x1][1] >= t) {
					minval = Math.min(minval, dData[x1][0]);
				}
			}
			for (int x2 = 0; x2 < nData.length; x2++) {
				if(nData[x2][1] >= t) {
					minval = Math.min(minval, nData[x2][0]);
				}
			}
			if(maxT < t) {
				System.out.println(-1);
			}else {
				System.out.println(minval);
			}
			
		}
	}
}

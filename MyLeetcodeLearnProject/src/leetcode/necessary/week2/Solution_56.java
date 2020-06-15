package leetcode.necessary.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution_56 {
	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		int[][] res = merge(intervals);
		for (int i = 0; i < res.length; i++) {
			System.out.println(Arrays.toString(res[i]));
		}
	}
	
	public static int[][] merge(int[][] intervals) {
		int len = intervals.length;
		if(len < 2) {
			return intervals;
		}
		//按照左端点升序排序
		Arrays.sort(intervals,Comparator.comparingInt(o -> o[0]));
		
		//创建list用于保存合并后的结果
		List<int []> res = new ArrayList<int[]>();
		res.add(intervals[0]);
		
		for(int i = 1 ; i < len ; i++) {
			int [] temp = intervals[i];
			
			//每次新遍历的列表与当前结果集中最后一个区间的末尾节点进行比较
			int [] peek = res.get(res.size()-1);
			
			if(temp[0] > peek[1]) {
				res.add(temp);
			}else {
				peek[1] = Math.max(temp[1], peek[1]);
			}
		}
		return res.toArray(new int[res.size()][]);
    }
}

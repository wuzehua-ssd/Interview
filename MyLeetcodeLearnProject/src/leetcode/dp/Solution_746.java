package leetcode.dp;

//最小花费爬台阶问题
public class Solution_746 {
	public static void main(String[] args) {
		int [] cost1 = {10, 15, 20};
		int [] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		System.out.println(minCostClimbingStairs(cost1));
		System.out.println(minCostClimbingStairs(cost2));
	}
	public static int minCostClimbingStairs(int[] cost) {
		int f1 = 0, f2 = 0;
        for (int i = cost.length - 1; i >= 0; --i) {
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    }
}

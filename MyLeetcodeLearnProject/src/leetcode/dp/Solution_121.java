package leetcode.dp;

//买卖股票的最佳时机
public class Solution_121 {
	public static void main(String[] args) {
		int [] prices1 = {7,1,5,3,6,4};
		int [] prices2 = {7,6,4,3,1};
		System.out.println(maxProfit(prices1));
		System.out.println(maxProfit(prices2));
	}
	public static int maxProfit(int [] prices) {
		int minPrice = prices[0]; //保存第i天及之前的最低价钱
		int maxprofit = 0; //保存最大利润
		for(int i = 1 ; i < prices.length ; i++) {
			if(prices[i] < minPrice) { //更新最低价
				minPrice = prices[i];
			}else if(prices[i] - minPrice > maxprofit) { //更新最大利润
				maxprofit = prices[i] - minPrice;
			}
		}
		return maxprofit; //返回最大利润
	}
}

@[Toc]

# 一、合并区间(leetcode-56)
## 问题描述
给出一个区间的集合，请合并所有重叠的区间。

## 示例
示例 1:
输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

示例 2:
输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

## 解法分析
本题可以考虑**贪心算法**，先将原区间集合按照左端点升序排好序后，依次遍历，如果新遍历的区间的左端点小于末尾区间的右端点，则对末尾区间的右端点进行更新；
如果新遍历区间的左端点大于末尾区间的右端点，说明其不含交集，将其加入结果集中。

## 代码实现
```
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
```
# 二、不同路径(leetcode-62)
## 问题描述
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
问总共有多少条不同的路径？

## 示例
示例 1:
输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右

示例 2:
输入: m = 7, n = 3
输出: 28

 提示：
1 <= m, n <= 100
题目数据保证答案小于等于 2 * 10 ^ 9

## 解法分析
本题目是一个典型的**动态规划**问题，对于当前位置dp[i][j],可能是从dp[i][j-1]向下走一步到达，也可能是从dp[i-1][j]向右走一步到达。

## 代码实现
```
	public int uniquePaths(int m, int n) {

        int [][] dp = new int [m][n];

        dp[0][0] = 1;
        for(int i = 1 ; i < m ;i++){
            dp[i][0] = 1;
        }
        for(int j = 1 ; j < n ; j++){
            dp[0][j] = 1;
        }

        for(int x = 1 ; x < m ;x++){
            for(int y = 1 ; y < n ; y++){
                dp[x][y] = dp[x-1][y] + dp[x][y-1];
            }
        }

        return dp[m-1][n-1];
    }
```

# 三、最小路径和(leetcode-64)
## 问题描述
给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
说明：每次只能向下或者向右移动一步。

## 示例
示例:
输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。

## 解法分析
本题相当于上一道题目的进阶版，也可以用**动态规划**的方法求出起点到dp[i][j]位置最小路径和，最后返回dp[m-1][n-1]即可。

## 代码实现
```
	public static int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		
		//状态定义
		int [][] dp = new int[m][n];
		
		//状态初始化
		dp[0][0] = grid[0][0];
		for(int i = 1 ; i < m ; i++) {
			dp[i][0] = dp[i-1][0] + grid[i][0];
		}
		for(int j = 1 ; j < n ; j++) {
			dp[0][j] = dp[0][j-1] + grid[0][j];
		}
		
		//状态转移
		for(int i=1 ; i < m ;i++) {
			for(int j = 1 ; j < n ;j++) {
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
			}
		}
		
		return dp[m-1][n-1];
	}
```

# 四、爬楼梯(leetcode-70)
## 问题描述
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
注意：给定 n 是一个正整数。

## 示例
示例 1：
输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶

示例 2：
输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶

## 解法分析
本题也是一个典型的**动态规划**问题，dp[i]为到第i级台阶的走法，dp[i] = dp[i-1]+dp[i-2],结果返回dp[n-1]即可。用递归做也比较简单。

## 代码实现
```
	public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        //1、状态定义
		//dp[i]表示爬到第i+1层台阶有几种爬法
		int [] dp = new int [n];
		
		//2、状态初始化
		//第一层台阶有一种爬法，第二层台阶有两种爬法
		dp[0] = 1;
		dp[1] = 2;
		
		//3、状态转移方程
		//dp[i] = dp[i-1] + dp[i-2]
		for(int i = 2 ; i < n ; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n-1];
    }
```

# 五、编辑距离(leetcode-72)
## 问题描述
给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
你可以对一个单词进行如下三种操作：
插入一个字符
删除一个字符
替换一个字符

## 示例
示例 1：
输入：word1 = "horse", word2 = "ros"
输出：3
解释：
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')

示例 2：
输入：word1 = "intention", word2 = "execution"
输出：5
解释：
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')

## 解法分析
首先我们需要对单词修改的操作进行分析，其实本质的操作方式只有三种：1、在A中插入一个字符；2、在B中插入一个字符；3、修改A中一个字符。
本题依旧可以使用动态规划求解，dp[i][j]表示word1前i个字符和word2前j个字符的最小编辑距离，则其可以由dp[i-1][j-1]、dp[i-1][j]和dp[i][j-1]比较求得。

## 代码实现
```
	public static int minDistance(String word1, String word2) {
		int m = word1.length();
	    int n = word2.length();

	    // 有一个字符串为空串
	    if (n * m == 0)
	      return n + m;

	    // DP 数组
	    int [][] D = new int[m + 1][n + 1];

	    // 边界状态初始化
	    for (int i = 0; i < m + 1; i++) {
	      D[i][0] = i;
	    }
	    for (int j = 0; j < n + 1; j++) {
	      D[0][j] = j;
	    }

	    // 计算所有 DP 值
	    for (int i = 1; i < m + 1; i++) {
	      for (int j = 1; j < n + 1; j++) {
	        int left = D[i - 1][j] + 1;
	        int down = D[i][j - 1] + 1;
	        int left_down = D[i - 1][j - 1];
	        if (word1.charAt(i - 1) != word2.charAt(j - 1))
	          left_down += 1;
	        D[i][j] = Math.min(left, Math.min(down, left_down));

	      }
	    }
	    return D[m][n];
	}
```

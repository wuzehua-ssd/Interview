@[Toc]

# 一、全排列(leetcode-46)
## 问题描述
给定一个没有重复数字的序列，返回其所有可能的全排列。
## 示例
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
## 解法分析
本题是典型的**回溯法**进行求解：即构造一棵解空间树，其叶子节点就是符合题目要求的排列。
## 代码实现
```
	public static List<List<Integer>> permute(int [] nums){
		//创建集合保存最终输出结果
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		//调用回溯函数
		backTrack(0, list, nums);
		return list;
	}
	/**
	 * 回溯主方法，将叶子节点存入解集，非叶子节点利用元素交换方法得到全排列
	 * @param t 当前层数
	 * @param list 输出解集
	 * @param nums 源数字序列
	 */
	public static void backTrack(int t , List<List<Integer>> list , int [] nums) {
		//到达解空间树叶子节点时，将结果保存到输出集合中
		if (t == nums.length) {
			List<Integer> arr = new ArrayList<Integer>();
			for (int i = 0; i < nums.length; i++) {
				arr.add(nums[i]);
			}
			list.add(arr);
		} else { // 未到达叶子节点时
			for (int i = t; i < nums.length; i++) {
				// 将x[t] 和其之后的元素依次进行交换
				swap(nums, i, t);
				// 递归对下一层进行回溯
				backTrack(t + 1, list, nums);
				// 交换后的元素再换回来保持原始状态
				swap(nums, i, t);
			}
		}
	}
	public static void swap(int [] nums , int i , int t) {
		int temp = nums[i];
		nums[i] = nums[t];
		nums[t] = temp;
	}
```
# 二、旋转图像(leetcode-48)
## 问题描述
给定一个 n × n 的二维矩阵表示一个图像。
将图像顺时针旋转 90 度。
说明：
你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
## 示例
示例 1:
给定 matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],
原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]

示例 2:
给定 matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 
原地旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
## 解法分析
本题可以将顺时针旋转90°分解为先上下翻转，再按正对角线交换元素即可。
## 代码实现
```
	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		//先进行上下翻转
		for (int i = 0; i < n / 2; i ++){
            int[] tmp = matrix[i];
            matrix[i] = matrix[n - i - 1];
            matrix[n - i - 1] = tmp;
        }
        //再对角翻转
        for (int i = 0; i < n; i ++){
            for (int j= i + 1; j < n; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
```
# 三、字母异位词分组(leetcode-49)
## 问题描述
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
## 示例
输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
## 解法分析
字母异位词的字符串排序后相同，所以可以用这点进行求解。
## 代码实现
```
	public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
```
# 四、最大子序和(leetcode-53)
## 问题描述
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
## 示例
输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
## 解法分析
这是一个典型的动态规划问题，dp[i]表示以nums[i]结尾的子序和的最大值，状态转移方程为：dp[i] = Math.max(dp[i-1], 0) + nums[i]。
## 代码实现
```
	public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
			return 0;
		}
		int max = 0;
		
		//1、状态定义
		//dp[i]表示前i个元素最大子序和
		int [] dp = new int[nums.length];
		
		//2、状态初始化
		//数组中第一个元素的最大和就是第一个元素值
		dp[0] = nums[0];
		max = nums[0];
		
		//3、状态转移：dp[i] = max(dp[i - 1], 0) + nums[i]
		for(int i = 1 ; i < nums.length ; i++) {
			dp[i] = Math.max(dp[i-1], 0) + nums[i];
			max = Math.max(max, dp[i]);
		}
		
		return max;
    }
```
# 五、跳跃游戏(leetcode-55)
## 问题描述
给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个位置。
## 示例
示例 1:
输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。

示例 2:
输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。

## 解法分析
本题可以使用**贪心**算法，用一个变量实时维护可达的最远位置，对数组进行遍历，当其最大可达位置大于等于终点时返回true，否则返回false。

## 代码实现
```
	public static boolean canJump(int [] nums) {
		int n = nums.length;
        int rightmost = 0; //右边最远可达点
        for (int i = 0; i < n; ++i) { //进行遍历
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]); //更新右边最远可达点
                if (rightmost >= n - 1) { //如果右边最远可达点远于终点，返回true
                    return true;
                }
            }
        }
        return false;
	}
```
# 总结
这几天算法学习有所懈怠，这次选取的五道题都比较基础，但是算法思想比较丰富，值得仔细品味品味。
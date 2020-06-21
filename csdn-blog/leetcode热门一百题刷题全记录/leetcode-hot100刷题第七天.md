@[Toc]

# 一、颜色分类（leetcode-75）
## 问题描述
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
（注：不能使用代码库中排序函数）

## 示例
输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]

## 解法分析
本题较为常规，因为数组只有0、1、2三个元素区分，所以考虑将所有的0放在数组左边，所有的2放在数组右边，即可以得到题目要求的排序数组。
具体而言，就是用前后两个指针分别探测0元素的最右边界和2元素的最左边界，用一个指针遍历一遍所给数组即可。

## 代码实现
```
public static void sortColors(int [] nums) {
		int p0 = 0;
		int p2 = nums.length-1;
		int cur = 0;
		
		int temp = 0;
		while(cur <= p2) {
			if(nums[cur] == 0) {//交换p0和cur位置元素
				temp = nums[cur];
				nums[cur] = nums[p0];
				nums[p0] = temp;
				cur++;
				p0++;
			}else if(nums[cur] == 2){//交换cur和p2的值
				temp = nums[cur];
				nums[cur] = nums[p2];
				nums[p2] = temp;
				//cur++; //考虑到左边的值之前扫描过，而与p2交换的值还未扫描过，因为不能++
				p2--;
			}else {//无交换发生，移动cur
				cur++;
			}
			
		}
	}
```

# 二、最小覆盖字串（leetcode-76）
## 问题描述
给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。

## 示例
输入: S = "ADOBECODEBANC", T = "ABC"
输出: "BANC"

## 解法分析
此题可以使用**滑动窗口**方法进行解决：即先通过增大窗口大小找到可行解，再通过缩小滑动窗口大小找到最优解。具体思路如下：


## 代码实现
```
public class Solution_76 {
	static Map<Character, Integer> ori = new HashMap<Character, Integer>(); //维护模式字符串中字符及对应个数
    static Map<Character, Integer> cnt = new HashMap<Character, Integer>(); //维护当前滑动窗口中字符及其对应个数


	public static void main(String[] args) {
		String string = "ADOBECODEBANC";
		String tString = "ABC";
		System.out.println(minWindow(string, tString));
	}
	
	public static String minWindow(String s, String t) {
		int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1); //将t字符串中字符和对应个数放入ori中
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);//遇到符合在t字符串中的字符，将其保存在cnt中
            }
            while (check() && l <= r) { //满足是解的时候，左界限l右移
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
	}
	
	 public static boolean check() { //用于判断当前窗口是否为解
	        Iterator iter = ori.entrySet().iterator(); 
	        while (iter.hasNext()) { 
	            Map.Entry entry = (Map.Entry) iter.next(); 
	            Character key = (Character) entry.getKey(); 
	            Integer val = (Integer) entry.getValue(); 
	            if (cnt.getOrDefault(key, 0) < val) {
	                return false;
	            }
	        } 
	        return true;
	    }
}

```

# 三、子集（leetcode-78）
## 问题描述
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。

## 示例
输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

## 解法分析
本题想法思路较为简单，难点应该在于怎么将简单的思考过程用程序语言优美的呈现出来。leetcode官方题解给了递归，回溯，字典排序三种解法实现。
因为回溯题是本人的弱项，所以此题打算用**回溯法**进行思考求解。

## 代码实现
```
public class Solution_78 {
	static List<List<Integer>> output = new ArrayList();
	static int n, k;

	public static void main(String[] args) {
		int [] nums = {1,2,3};
		subsets(nums);
		System.out.println(output);
	}
	
	public static List<List<Integer>> subsets(int[] nums) {
		n = nums.length;
		for (k = 0; k < n + 1; ++k) {
			backtrack(0, new ArrayList<Integer>(), nums);
		}
		return output;
	}
	
	public static void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
	    // if the combination is done
	    if (curr.size() == k)
	      output.add(new ArrayList(curr));
	    for (int i = first; i < n; ++i) {
	      // add i into the current combination
	      curr.add(nums[i]);
	      // use next integers to complete the combination
	      backtrack(i + 1, curr, nums);
	      // backtrack
	      curr.remove(curr.size() - 1);
	    }
	  }

}
```

# 四、单词搜索（leetcode-79）
## 问题描述
给定一个二维网格和一个单词，找出该单词是否存在于网格中。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

## 示例
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false

## 解法分析
本题考虑使用深度优先搜索算法实现，对每个吻合的点，搜寻其上下左右四个方向，找到与下一个字符匹配的路径，按该思路继续搜索，即可得到结果。

## 代码实现
```
public class Solution_79 {
	static boolean[][] marked ;
	static int[][] direction = {{-1,0},{0,-1},{0,1},{1,0}};//用于移动搜索方向
	static int m; //行数
	static int n; //列数
	
	
	public static void main(String[] args) {
		char[][] board = {
				{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
		        };
		String string1 = "ABCCED";
		String string2 = "SEE";
		String string3 = "ABCB";
		System.out.println(exist(board, string1));
		System.out.println(exist(board, string2));
		System.out.println(exist(board, string3));
	}
	public static boolean exist(char[][] board, String word) {
		m = board.length;
		if(m == 0) {
			return false;
		}
		n = board[0].length;
		marked = new boolean[m][n]; //marked初始化
		
		for(int i = 0 ; i < m ; i++) {
			for(int j = 0 ; j < n ;j++) {
				if(dfs(i, j, 0, board, word)) { //使用深度优先搜索
					return true;
				}
			}
		}
		return false;
    }
	
	public static boolean dfs(int i,int j,int start,char[][] board,String word) {
		if(start == word.length() -1) {
			return board[i][j] == word.charAt(start); 
		}
		if(board[i][j] == word.charAt(start)) {
			marked[i][j] = true;
			for(int k = 0 ; k < 4 ; k++) { //遍历上下左右四个方向进行深度优先搜索
				int newX = i + direction[k][0];
				int newY = j + direction[k][1];
				if(inArea(newX, newY) && !marked[newX][newY]) {
					if(dfs(newX, newY, start+1, board, word)) {
						return true;
					}
				}
			}
			marked[i][j] = false;
		}
		return false;
	}
	
	public static boolean inArea(int x, int y) { //判断是否在边界内
		return x >= 0 && x < m && y >= 0 && y < n;
	}
}
```

# 五、柱状图中最大矩形（leetcode-84）
## 问题描述
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最大面积。

## 示例
输入: [2,1,5,6,2,3]
输出: 10

## 解法分析
此题首先肯定可以用暴力法进行破解，遍历出每两个柱子形成的最大矩形面积，然后取最大值，但这样显然时间开销过大，所以我们就要想出一种更为好的解法，考虑到算法优化一般可以使用
空间换时间，此题又是一维数组，所以可以考虑**单调栈**实现。具体思路如下：维护一个单调递增的栈，用一个数组存储某个柱子的左右边界，最后根据左右边界算的的结果更新最大矩形大小。

## 代码实现
```
public class Solution_84 {
	public static void main(String[] args) {
		int [] heights = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(heights));
	}
	public static int largestRectangleArea(int[] heights) {
		int n = heights.length;
        int[] left = new int[n]; //确定最大矩形左边界
        int[] right = new int[n]; //确定最大矩形右边界
        Arrays.fill(right, n);
        
        Stack<Integer> mono_stack = new Stack<Integer>(); //单调栈声明
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) { //数组不为空且当前柱子高度小于栈顶时
                right[mono_stack.peek()] = i; //得出右边界
                mono_stack.pop(); //弹出栈顶元素
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek()); //左边界
            mono_stack.push(i); //入栈
        }
        
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]); //更新最大矩形大小
        }
        return ans;
    }
}
```


# 总结
秋招在即，也算从期末复习中走了出来，接下来几个月，踏踏实实闭关修炼，希望能在秋招有不错的收获~
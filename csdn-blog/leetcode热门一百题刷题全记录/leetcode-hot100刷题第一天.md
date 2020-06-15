@[Toc]

# 一、两数之和问题（leetcode-1）

## 问题描述
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

## 示例
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

## 解法分析
（1）：**暴力法**实现：很容易想到的一种解法，对数组中每个元素x进行遍历，并查找是否存在一个值与 target - xtarget−x 相等的目标元素。
		时间复杂度为O(n^2)，相对较高，空间复杂度为O(1)。
（2）：**两遍哈希法**：为了对运行时间复杂度进行优化，我们需要一种更有效的方法来检查数组中是否存在目标元素。如果存在，我们需要找出它的索引。
		保持数组中的每个元素与其索引相互对应的最好方法是什么？哈希表。第一次遍历时将数组的nums[i]作为key，i作为value存入哈希表中，第二次
		遍历哈希表中每个元素时，可以直接用哈希表查找，将时间复杂度降低为了O(n),但是相应的我们用了时间换空间的方法，因此其空间复杂度变为了
		O(n);
（3）：**一遍哈希法**：这其实是对**两遍哈希法**的一种优化，我们在每次向哈希表中存储元素时，可以直接查找当前哈希表中是否有满足条件的元素，
		有就直接返回结果，没有再将当前元素存入哈希表。
         

## 代码实现
```
    //本题有暴力法、两遍哈希、一遍哈希等多种解法，本次采用一遍哈希
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(); //创建哈希表
		for(int i = 0 ; i < nums.length ; i++) { //遍历数组元素
			int temp = target - nums[i]; 
			if(map.containsKey(temp)) { //如果当前map中存放有目标值与当前数组元素得差值，直接返回结果
				return new int [] {map.get(temp),i};
			}
			map.put(nums[i], i); //没有则把当前nums[i]作为key，i作为value存入map
		}
		throw new IllegalArgumentException("No two sum solution!"); //没找到则抛出自定义异常
    }
```


# 二、两数相加问题（leetcode-2）
## 问题描述
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

## 示例
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

## 解法分析
此题解法较为简单，类似于初等数学运算，因为链表各自的位数是按照逆序的方式存储，所以可以直接从l1和l2的表头开始相加，并设置一个进位carry用于保存进位即可。
（注意区别'/'是取商，'%'是取余数）

## 代码实现
```
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		 ListNode dummyHead = new ListNode(0); //创建结果链表的头节点
		 ListNode p = l1, q = l2, curr = dummyHead; 
		 int carry = 0; //声明carry变量用于保存进位值
		 while (p != null || q != null) { 
			 //若有链表已经遍历到头，便将其值置为0
			 int x = (p != null) ? p.val : 0;
		     int y = (q != null) ? q.val : 0;
		     int sum = carry + x + y; 
		     carry = sum / 10; //计算进位值
		     curr.next = new ListNode(sum % 10); //计算当前节点的值
		     curr = curr.next; //将指针指向下一节点
		     if (p != null) p = p.next; 
		     if (q != null) q = q.next;
		  }
		  if (carry > 0) {
		     curr.next = new ListNode(carry); //遍历完成后若任有进位值，则加一个节点
		  }
		  return dummyHead.next;
    }
```

# 三、无重复字符的最长字串（leetcode-3）
## 问题描述
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

## 示例
(1) 输入: "abcabcbb"
    输出: 3 
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
(2) 输入: "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
(3) 输入: "pwwkew"
    输出: 3 
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
	
## 解法分析
(1)、**暴力法**：逐个检查所有的子字符串，看它是否不含有重复的字符。对每个字串调用编写的allUnique()函数,该函数内部可以使用hashset来判断重复字符。
(2)、**滑动窗口**：也是利用hashSet的一种方法，对字符串的每个下标为i的字符，令j=i+1；然后向右滑动到遇到重复元素为止。
(3)、**优化滑动窗口**：上面的滑动窗口法需要执行2n步骤，但其实如果 s[j] 在 [i,j) 范围内有与 j'重复的字符，我们不需要逐渐增加i。我们可以直接跳过 [i，j']
范围内的所有元素，并将 i 变为 j' + 1。

作者：LeetCode
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetcod/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

## 代码实现
**暴力法**
```
	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int ans = 1;
		for(int i = 0 ; i < n-1 ; i++) {
			for(int j = i+1 ; j < n ; j++) {
				if(allUnique(s, i, j)) { //遍历得到所有字串并进行判断是否有重复元素
					ans = Math.max(ans, j-i+1); //更新最大无重复字串长度
				}
			}
		}
		return ans;
	}

	public static boolean allUnique(String s, int start, int end) {
		Set<Character> set = new HashSet<Character>();
		for(int i = start ; i < end ; i++) {
			Character character  = s.charAt(i);
			if(set.contains(character)) { //如果set中已经包含当前元素，说明已重复，返回false
				return false;
			}
			set.add(character); //不包含则把当前元素加入进set中
		}
		return true;
	}
```

**滑动窗口**
```
	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<Character>(); //创建set用于保存滑动窗口中的值
		int ans = 0 , i = 0 , j = 0; 
		while(i < n && j < n) { 
			if(! set.contains(s.charAt(j))) { //如果当前set不包含当前j位置字符，j向右滑动
				set.add(s.charAt(j++));
				ans = Math.max(ans, j-i);
			}else {
				set.remove(s.charAt(i++)); //包含了说明以i开头的最长字符串已经找到，i向右滑动。
			}
		}
		return ans;
	}
```

**优化滑动窗口**
```
	public static int lengthOfLongestSubstring(String s) {
		int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // 存储字符下标
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
	}
```

# 四、寻找两个有序数组的中位数（leetcode-4）
## 问题描述
给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
你可以假设 nums1 和 nums2 不会同时为空。

## 示例
示例1：
nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0

示例2：
nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5

## 解法分析
此题如果不考虑时间复杂度较为轻松，只用将两个数组归并排序后求解即可，但时间复杂度为O(m+n)不满足要求，leetcode给出的官方题解分析较多，考虑到篇幅原因，这
篇博客先贴出代码，后面将专门写一篇博客进行详细分析。

## 代码实现
```
	public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
```

# 五、最长回文字符串（leetcode-5）
## 问题描述
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

## 示例
示例1：
输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。

示例2：
输入: "cbbd"
输出: "bb"

## 解法分析
本题解法较多，这里采用**动态规划法**求解：使用dp[i][j]数组；dp[i][j]表示字符串中从i到j的位置是否为回文；先初始化1字母和2字母回文，然后用状态转移方程
dp[i+1][j+1] = dp[i][j] if(i和j处字符相同)。

## 代码实现
```
    public static String longestPalindrome(String s) {
		if(s == null || s.equals("")) {
            return s;
        }

        int len = s.length();
        char[] chars = s.toCharArray();

        //状态定义
        boolean[][] dp = new boolean[len][len];
        
        // 1字母初始化
        for(int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        // 2字母初始化 P(i,i+1)=(Si==Si+1)
        for(int i = 0; i < len - 1; i++) {
            dp[i][i+1] = (chars[i] == chars[i+1]);
        }

        int left = 0;
        int right = 0;
        int max = 1;
        for(int i = len - 2; i >= 0; i--) {
            for(int j = i + 1; j < len; j++) {
                // P(i,j)=(P(i+1,j−1) and Si==Sj)
                if(j != i+1) {
                    dp[i][j] = dp[i+1][j-1] && chars[i] == chars[j];
                }
                if(dp[i][j] && max < j - i + 1) {
                    max = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right+1);
	}
```

# 总结
这是博主写的第一篇博客，博客问题和解法都主要来源于leetcode官网，算法的学习还是在于平时多写多积累，亡羊补牢，希望现在为时未晚吧。以后还会考虑开一些其他的
栏目，目前还打算做一下面试知识的总结栏目，希望不会鸽吧~
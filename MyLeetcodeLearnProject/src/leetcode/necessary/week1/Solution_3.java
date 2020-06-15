package leetcode.necessary.week1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Solution_3 {
	public static void main(String[] args) {
		String s1 = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s1));
		String s2 = "bbbbb";
		System.out.println(lengthOfLongestSubstring(s2));
		String s3 = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s3));
	}

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
}

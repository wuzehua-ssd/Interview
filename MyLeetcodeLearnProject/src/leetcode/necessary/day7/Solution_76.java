package leetcode.necessary.day7;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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

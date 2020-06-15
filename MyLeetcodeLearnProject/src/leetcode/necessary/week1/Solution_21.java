package leetcode.necessary.week1;

public class Solution_21 {
	public static void main(String[] args) {
		System.out.println("成功！");
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		//其中一个链表的指针指向为空时，递归终止
		if (l1 == null) {
			return l2; 
		}
		if (l2 == null) {
			return l1;
		}
		//画图较为容易理解，相当于每次取一个较小的节点连接起来
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	 }
}

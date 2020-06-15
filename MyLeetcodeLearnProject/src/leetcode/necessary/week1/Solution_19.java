package leetcode.necessary.week1;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}

public class Solution_19 {
	public static void main(String[] args) {
		
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode pre = new ListNode(0); //声明pre指向链表头节点最后用于返回
		pre.next = head;
		ListNode start = pre, end = pre; //声明快指针start和慢指针end
		while (n != 0) { //快指针先走n步
			start = start.next;
			n--;
		}
		while (start.next != null) { //快慢指针在快指针没走到头时一起迁移
			start = start.next;
			end = end.next;
		}
		end.next = end.next.next; //删除此时end指针指向的下一个节点
		return pre.next; //返回链表头指针
	}
}

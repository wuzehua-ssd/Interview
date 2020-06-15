package leetcode.necessary.week1;

public class Solution_2 {
	public static void main(String[] args) {
		System.out.println("成功！");
	}
	
	/*public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
    }*/
}


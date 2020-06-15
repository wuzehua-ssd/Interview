package leetcode.necessary.week1;

public class Solution_23 {
	public static ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;//每次待处理的链表个数
        if(len==0)return null;//处理null

        while(len>1){
            int i;
            //两两合并，注意到这里将位置2i与2i+1的两个链表合并到位置i上。
            //如有不清楚的可以自己画个数组看看
            for( i = 0;i <len/2;i++){
                lists[i]=mergeTwoLists(lists[2*i],lists[2*i+1]) ;  
            }
            //处理奇数的情况。把最后一个链表放到下次待求解数组的末端，顺便解决向上取整的问题
            if((len%2)!=0){
                lists[i]=lists[len-1];
                len++;
            }

            //规模减半
            len/=2;

        }

        return lists[0];
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

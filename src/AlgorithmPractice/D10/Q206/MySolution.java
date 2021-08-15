package AlgorithmPractice.D10.Q206;

//https://leetcode-cn.com/problems/reverse-linked-list/

public class MySolution {
    public ListNode reverseList(ListNode head)
    {
        ListNode dummy = new ListNode();
        while (head != null)
        {
            ListNode temp = dummy.next;
            dummy.next = head;
            head = head.next;
            dummy.next.next = temp;
        }
        System.gc();    // magic code!!!
        return dummy.next;
    }
}

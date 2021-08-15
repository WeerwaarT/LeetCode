package AlgorithmPractice.D5.Q876;

//https://leetcode-cn.com/problems/middle-of-the-linked-list/

public class MySolution {
    public ListNode middleNode(ListNode head)
    {
        if (head == null)
        {
            return null;
        }
        ListNode copy = head;
        while (copy != null && copy.next != null)
        {
            copy = copy.next.next;
            head = head.next;
        }
        return head;
    }
}

package AlgorithmPractice.D5.Q19;

//https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/

public class MySolution {
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        if (head == null)
        {
            return null;
        }
        ListNode copy2 = head;
        while (n-- > 0)
        {
            copy2 = copy2.next;
        }
        if (copy2 == null)
        {
            return head.next;
        }
        ListNode copy1 = head;
        while (copy2.next != null)
        {
            copy1 = copy1.next;
            copy2 = copy2.next;
        }
        if (copy1.next == null)
        {
            return null;
        }
        copy1.next = copy1.next.next;
        return head;
    }
}

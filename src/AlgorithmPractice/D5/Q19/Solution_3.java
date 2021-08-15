package AlgorithmPractice.D5.Q19;

//https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/

public class Solution_3 {
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i)
        {
            first = first.next;
        }
        while (first != null)
        {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-b-61/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

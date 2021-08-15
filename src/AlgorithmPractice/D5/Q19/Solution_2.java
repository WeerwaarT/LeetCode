package AlgorithmPractice.D5.Q19;

//https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/

import java.util.Deque;
import java.util.LinkedList;

public class Solution_2 {
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null)
        {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i)
        {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-b-61/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

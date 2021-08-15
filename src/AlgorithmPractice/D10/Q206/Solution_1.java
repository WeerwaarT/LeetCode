package AlgorithmPractice.D10.Q206;

//https://leetcode-cn.com/problems/reverse-linked-list/

public class Solution_1 {
    public ListNode reverseList(ListNode head)  // 迭代
    {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode-solution-d1k2/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

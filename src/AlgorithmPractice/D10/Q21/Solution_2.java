package AlgorithmPractice.D10.Q21;

public class Solution_2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) // 迭代
    {
        ListNode preHead = new ListNode(-1);

        ListNode prev = preHead;
        while (l1 != null && l2 != null)
        {
            if (l1.val <= l2.val)
            {
                prev.next = l1;
                l1 = l1.next;
            }
            else
            {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return preHead.next;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

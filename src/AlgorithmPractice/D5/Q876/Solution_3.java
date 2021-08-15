package AlgorithmPractice.D5.Q876;

//https://leetcode-cn.com/problems/middle-of-the-linked-list/

public class Solution_3 {
    public ListNode middleNode(ListNode head)
    {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/middle-of-the-linked-list/solution/lian-biao-de-zhong-jian-jie-dian-by-leetcode-solut/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

package AlgorithmPractice.D5.Q876;

//https://leetcode-cn.com/problems/middle-of-the-linked-list/

public class Solution_2 {
    public ListNode middleNode(ListNode head)
    {
        int n = 0;
        ListNode cur = head;
        while (cur != null)
        {
            ++n;
            cur = cur.next;
        }
        int k = 0;
        cur = head;
        while (k < n / 2)
        {
            ++k;
            cur = cur.next;
        }
        return cur;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/middle-of-the-linked-list/solution/lian-biao-de-zhong-jian-jie-dian-by-leetcode-solut/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

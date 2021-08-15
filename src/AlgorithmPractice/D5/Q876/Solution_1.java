package AlgorithmPractice.D5.Q876;

//https://leetcode-cn.com/problems/middle-of-the-linked-list/

public class Solution_1 {
    public ListNode middleNode(ListNode head)
    {
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head != null)
        {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/middle-of-the-linked-list/solution/lian-biao-de-zhong-jian-jie-dian-by-leetcode-solut/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

package Y2021.M07.D21;

//https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/

import java.util.HashSet;
import java.util.Set;

public class Solution_1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        Set<ListNode> visited = new HashSet<>();
        ListNode temp = headA;
        while (temp != null)
        {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null)
        {
            if (visited.contains(temp))
            {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solution/liang-ge-lian-biao-de-di-yi-ge-gong-gong-pzbs/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

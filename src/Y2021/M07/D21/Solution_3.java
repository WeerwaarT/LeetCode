package Y2021.M07.D21;

//https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/

public class Solution_3 {
    public ListNode getIntersectionNode(ListNode a, ListNode b)
    {
        int c1 = 0, c2 = 0;
        ListNode ta = a, tb = b;
        while (ta != null && c1++ >= 0)
            ta = ta.next;
        while (tb != null && c2++ >= 0)
            tb = tb.next;
        int d = c1 - c2;
        if (d > 0)
        {
            while (d-- > 0)
                a = a.next;
        }
        else if (d < 0)
        {
            d = -d;
            while (d-- > 0)
                b = b.next;
        }
        while (a != b)
        {
            a = a.next;
            b = b.next;
        }
        return a;
    }
}

//作者：AC_OIer
//链接：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solution/gong-shui-san-xie-zhao-liang-tiao-lian-b-ifqw/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

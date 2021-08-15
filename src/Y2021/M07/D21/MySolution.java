package Y2021.M07.D21;

//https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/

public class MySolution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        if (headA == null || headB == null)
        {
            return null;
        }
        ListNode headACopy = headA, headBCopy = headB;
        int countA = 1, countB = 1;
        while (headACopy.next != null)
        {
            headACopy = headACopy.next;
            ++countA;
        }
        while (headBCopy.next != null)
        {
            headBCopy = headBCopy.next;
            ++countB;
        }
        if (headACopy != headBCopy)
        {
            return null;
        }
        if (countA < countB)
        {
            int diff = countB - countA;
            while (diff-- != 0)
            {
                headB = headB.next;
            }

        }
        else
        {
            int diff = countA - countB;
            while (diff-- != 0)
            {
                headA = headA.next;
            }
        }
        while (headA != null)
        {
            if (headA.val == headB.val)
            {
                if (headA == headB)
                {
                    return headA;
                }
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}

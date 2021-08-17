package Y2021.M08.D17;

//https://leetcode-cn.com/problems/student-attendance-record-i/

public class Solution_1 {
    public boolean checkRecord(String s)
    {
        int absents = 0, lates = 0;
        int n = s.length();
        for (int i = 0; i < n; i++)
        {
            char c = s.charAt(i);
            if (c == 'A')
            {
                absents++;
                if (absents >= 2)
                {
                    return false;
                }
            }
            if (c == 'L')
            {
                lates++;
                if (lates >= 3)
                {
                    return false;
                }
            }
            else
            {
                lates = 0;
            }
        }
        return true;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/student-attendance-record-i/solution/xue-sheng-chu-qin-ji-lu-i-by-leetcode-so-fcol/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

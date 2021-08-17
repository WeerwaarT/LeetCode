package Y2021.M08.D17;

//https://leetcode-cn.com/problems/student-attendance-record-i/

public class MySolution {
    public boolean checkRecord(String s)
    {
        int countOfA = 0, countOfL = 0;
        for (char c : s.toCharArray())
        {
            if (c == 'P')
            {
                countOfL = 0;
            }
            else if (c == 'A')
            {
                countOfL = 0;
                ++countOfA;
                if (!(countOfA < 2))
                    return false;
            }
            else
            {
                ++countOfL;
                if (countOfL > 2)
                    return false;
            }
        }
        return true;
    }
}

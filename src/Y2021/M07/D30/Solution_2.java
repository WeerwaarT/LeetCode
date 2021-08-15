package Y2021.M07.D30;

//https://leetcode-cn.com/problems/excel-sheet-column-number/

public class Solution_2 {
    public int titleToNumber(String columnTitle)
    {
        if (columnTitle == null || columnTitle.length() < 1)
        {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < columnTitle.length(); i++)
        {
            count += changeToNumber(columnTitle.charAt(i)) * Math.pow(26, columnTitle.length() - 1 - i);
        }
        return count;
    }

    public int changeToNumber(char c)
    {
        return c - 'A' + 1;
    }
}

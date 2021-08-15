package Y2021.M07.D30;

//https://leetcode-cn.com/problems/excel-sheet-column-number/

public class MySolution {
    public int titleToNumber(String columnTitle)
    {
        int result = 0;
        char[] chars = columnTitle.toCharArray();
        for (int i = 0; i < chars.length; ++i)
        {
            result += Math.pow(26, chars.length - 1 - i) * (chars[i] - 64);
        }
        return result;
    }

    public static void main(String[] args)
    {
        System.out.println(new MySolution().titleToNumber("ZY"));
    }
}

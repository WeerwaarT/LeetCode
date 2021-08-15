package Y2021.M07.D23;

//https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/

import java.util.Arrays;

public class MySolution {
    public boolean isCovered(int[][] ranges, int left, int right)
    {
        if (ranges.length == 0)
        {
            return false;
        }
        Arrays.sort(ranges, (o1, o2) ->
        {
            if (o1[0] - o2[0] != 0)
            {
                return o1[0] - o2[0];
            }
            else
            {
                return o1[1] - o2[1];
            }
        });
        for (int[] range : ranges)
        {
            int tempLeft = range[0];
            int tempRight = range[1];
            if (tempLeft > left)
            {
                return false;
            }
            else
            {
                if (tempRight >= right)
                {
                    return true;
                }
                else if (tempRight >= left)
                {
                    left = tempRight + 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        System.out.println(new MySolution().isCovered(new int[][]{{3,4},{1,8},{1,6}},1,11));
    }
}

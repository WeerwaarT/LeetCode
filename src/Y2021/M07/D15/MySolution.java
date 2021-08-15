package Y2021.M07.D15;

//https://leetcode-cn.com/problems/maximum-element-after-decreasing-and-rearranging/

import java.util.Arrays;

public class MySolution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr)
    {
        Arrays.sort(arr);
        if (arr.length == 0)
        {
            return 0;
        }
        else if (arr.length == 1)
        {
            return 1;
        }
        else
        {
            arr[0] = 1;
        }
        for (int i = 0; i < arr.length; i++)
        {
            if (Math.abs(arr[i] - arr[i + 1]) > 1)
            {
                arr[i + 1] = arr[i] + 1;
            }
        }
        return arr[arr.length - 1];
    }
}

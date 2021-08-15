package Y2021.M07.D19;

//https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MySolution {
    public int maxFrequency(int[] nums, int k)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
        {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int maxFrequency = Integer.MIN_VALUE;
        Integer[] newNums = map.keySet().toArray(new Integer[0]);
        Arrays.sort(newNums);
        for (int i = 0; i < newNums.length; ++i)
        {
            int n = k;
            int j = i - 1;
            int count = map.get(newNums[i]);
            while (j > -1)
            {
                int diff = newNums[i] - newNums[j];
                int subCount = Math.floorDiv(n, diff);
                if (subCount == 0)
                {
                    break;
                }
                int num = map.get(newNums[j]);
                if (subCount < num)
                {
                    count += subCount;
                    break;
                }
                else
                {
                    count += num;
                    n -= num * diff;
                    --j;
                }
            }
            maxFrequency = Math.max(maxFrequency, count);
        }
        return maxFrequency;
    }
}

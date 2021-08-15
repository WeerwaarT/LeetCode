package Y2021.M07.D26;

//https://leetcode-cn.com/problems/minimum-operations-to-make-a-subsequence/

import java.util.HashMap;
import java.util.Map;

public class Solution_3 {
    public int minOperations(int[] target, int[] arr)
    {
        int m = target.length, n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; ++i) map.put(target[i], i);
        for (int i = 0; i < n; ++i) arr[i] = map.getOrDefault(arr[i], -1);
        int[] d = new int[n + 1];
        int len = 0;
        d[len] = -1;
        for (int num : arr)
        {
            if (num == -1) continue;
            if (d[len] < num)
            {
                d[++len] = num;
            }
            else
            {
                int l = 1, r = len;
                while (l <= r)
                {
                    int mid = l + r >>> 1;
                    if (d[mid] < num) l = mid + 1;
                    else r = mid - 1;
                }
                d[l] = num;
            }
        }
        return m - len;
    }
}

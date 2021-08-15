package Y2021.M07.D26;

//https://leetcode-cn.com/problems/minimum-operations-to-make-a-subsequence/

import java.util.*;

public class Solution_2 {
    public int minOperations(int[] t, int[] arr)
    {
        int n = t.length, m = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
        {
            map.put(t[i], i);
        }
        List<Integer> list = new ArrayList<>();
        for (int x : arr)
        {
            if (map.containsKey(x)) list.add(map.get(x));
        }
        int len = list.size();
        int[] g = new int[len + 1];
        Arrays.fill(g, Integer.MAX_VALUE);
        int max = 0;
        for (Integer integer : list)
        {
            int l = 0, r = len;
            while (l < r)
            {
                int mid = l + r + 1 >> 1;
                if (g[mid] < integer) l = mid;
                else r = mid - 1;
            }
            int clen = r + 1;
            g[clen] = Math.min(g[clen], integer);
            max = Math.max(max, clen);
        }
        return n - max;
    }
}

//作者：AC_OIer
//链接：https://leetcode-cn.com/problems/minimum-operations-to-make-a-subsequence/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-oj7yu/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

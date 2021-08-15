package Y2021.M07.D25;

//https://leetcode-cn.com/problems/restore-the-array-from-adjacent-pairs/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_1 {
    public int[] restoreArray(int[][] adjacentPairs)
    {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] adjacentPair : adjacentPairs)
        {
            map.putIfAbsent(adjacentPair[0], new ArrayList<>());
            map.putIfAbsent(adjacentPair[1], new ArrayList<>());
            map.get(adjacentPair[0]).add(adjacentPair[1]);
            map.get(adjacentPair[1]).add(adjacentPair[0]);
        }

        int n = adjacentPairs.length + 1;
        int[] ret = new int[n];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet())
        {
            int e = entry.getKey();
            List<Integer> adj = entry.getValue();
            if (adj.size() == 1)
            {
                ret[0] = e;
                break;
            }
        }

        ret[1] = map.get(ret[0]).get(0);
        for (int i = 2; i < n; i++)
        {
            List<Integer> adj = map.get(ret[i - 1]);
            ret[i] = ret[i - 2] == adj.get(0) ? adj.get(1) : adj.get(0);
        }
        return ret;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/restore-the-array-from-adjacent-pairs/solution/cong-xiang-lin-yuan-su-dui-huan-yuan-shu-v55t/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

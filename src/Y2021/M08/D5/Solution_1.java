package Y2021.M08.D5;

//https://leetcode-cn.com/problems/find-eventual-safe-states/

import java.util.ArrayList;
import java.util.List;

public class Solution_1 {
    public List<Integer> eventualSafeNodes(int[][] graph)
    {
        int n = graph.length;
        int[] color = new int[n];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i)
        {
            if (safe(graph, color, i))
            {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean safe(int[][] graph, int[] color, int x)
    {
        if (color[x] > 0)
        {
            return color[x] == 2;
        }
        color[x] = 1;
        for (int node : graph[x])
        {
            if (!safe(graph, color, node))
            {
                return false;
            }
        }
        color[x] = 2;
        return true;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/find-eventual-safe-states/solution/zhao-dao-zui-zhong-de-an-quan-zhuang-tai-yzfz/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

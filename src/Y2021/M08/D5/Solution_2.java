package Y2021.M08.D5;

//https://leetcode-cn.com/problems/find-eventual-safe-states/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_2 {
    public List<Integer> eventualSafeNodes(int[][] graph)
    {
        int n = graph.length;
        List<List<Integer>> rg = new ArrayList<>();
        for (int i = 0; i < n; ++i)
        {
            rg.add(new ArrayList<>());
        }
        int[] inDeg = new int[n];
        for (int x = 0; x < n; ++x)
        {
            for (int y : graph[x])
            {
                rg.get(y).add(x);
            }
            inDeg[x] = graph[x].length;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i)
        {
            if (inDeg[i] == 0)
            {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty())
        {
            int y = queue.poll();
            for (int x : rg.get(y))
            {
                if (--inDeg[x] == 0)
                {
                    queue.offer(x);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i)
        {
            if (inDeg[i] == 0)
            {
                ans.add(i);
            }
        }
        return ans;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/find-eventual-safe-states/solution/zhao-dao-zui-zhong-de-an-quan-zhuang-tai-yzfz/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

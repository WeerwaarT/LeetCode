package Y2021.M08.D6;

//https://leetcode-cn.com/problems/shortest-path-visiting-all-nodes/

import java.util.LinkedList;
import java.util.Queue;

public class Solution_1 {
    public int shortestPathLength(int[][] graph)
    {
        int n = graph.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] seen = new boolean[n][1 << n];
        for (int i = 0; i < n; ++i)
        {
            queue.offer(new int[]{i, 1 << i, 0});
            seen[i][1 << i] = true;
        }

        int ans = 0;
        while (!queue.isEmpty())
        {
            int[] tuple = queue.poll();
            int u = tuple[0], mask = tuple[1], dist = tuple[2];
            if (mask == (1 << n) - 1)
            {
                ans = dist;
                break;
            }
            // 搜索相邻的节点
            for (int v : graph[u])
            {
                // 将 mask 的第 v 位置为 1
                int maskV = mask | (1 << v);
                if (!seen[v][maskV])
                {
                    queue.offer(new int[]{v, maskV, dist + 1});
                    seen[v][maskV] = true;
                }
            }
        }
        return ans;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/shortest-path-visiting-all-nodes/solution/fang-wen-suo-you-jie-dian-de-zui-duan-lu-mqc2/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

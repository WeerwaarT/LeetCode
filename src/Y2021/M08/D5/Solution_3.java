package Y2021.M08.D5;

//https://leetcode-cn.com/problems/find-eventual-safe-states/

import java.util.*;

public class Solution_3 {
    int N = (int)1e4+10, M = 4 * N;
    int idx;
    int[] he = new int[N], e = new int[M], ne = new int[M];
    int[] cnts = new int[N];

    private void add(int a, int b)
    {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }

    public List<Integer> eventualSafeNodes(int[][] g)
    {
        int n = g.length;
        // 存反向图，并统计入度
        Arrays.fill(he, -1);
        for (int i = 0; i < n; i++)
        {
            for (int j : g[i])
            {
                add(j, i);
                cnts[i]++;
            }
        }

        // BFS 求反向图拓扑排序
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++)
        {
            if (cnts[i] == 0) d.addLast(i);
        }
        while (!d.isEmpty())
        {
            int poll = d.pollFirst();
            for (int i = he[poll]; i != -1; i = ne[i])
            {
                int j = e[i];
                if (--cnts[j] == 0) d.addLast(j);
            }
        }

        // 遍历答案：如果某个节点出现在拓扑序列，说明其进入过队列，说明其入度为 0
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            if (cnts[i] == 0) ans.add(i);
        }
        return ans;
    }
}

//作者：AC_OIer
//链接：https://leetcode-cn.com/problems/find-eventual-safe-states/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-isy6u/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

package Y2021.M08.D2;

//https://leetcode-cn.com/problems/network-delay-time/

import java.util.Arrays;

public class Solution_1 {
    public int networkDelayTime(int[][] times, int n, int k)
    {
        final int INF = Integer.MAX_VALUE / 2;
        int[][] g = new int[n][n];
        for (int i = 0; i < n; ++i)
        {
            Arrays.fill(g[i], INF);
        }
        for (int[] t : times)
        {
            int x = t[0] - 1, y = t[1] - 1;
            g[x][y] = t[2];
        }

        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; ++i)
        {
            int x = -1;
            for (int y = 0; y < n; ++y)
            {
                if (!used[y] && (x == -1 || dist[y] < dist[x]))
                {
                    x = y;
                }
            }
            used[x] = true;
            for (int y = 0; y < n; ++y)
            {
                dist[y] = Math.min(dist[y], dist[x] + g[x][y]);
            }
        }

        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/network-delay-time/solution/wang-luo-yan-chi-shi-jian-by-leetcode-so-6phc/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

package Y2021.M08.D2;

//https://leetcode-cn.com/problems/network-delay-time/

import java.util.Arrays;

public class Solution_2 {
    public int networkDelayTime(int[][] times, int n, int k)
    {
        // 邻接矩阵：graph
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++)
        {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }
        for (int[] time : times)
        {
            graph[time[0] - 1][time[1] - 1] = time[2];
        }
        // 访问列表：visited
        boolean[] visited = new boolean[n];
        // 距离列表：shortest
        int[] shortest = new int[n];
        Arrays.fill(shortest, Integer.MAX_VALUE);
        shortest[k - 1] = 0;
        // 迪杰斯特拉算法计算单源最短路径
        while (true)
        {
            int index = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++)
            {
                if (!visited[i] && min > shortest[i])
                {
                    index = i;
                    min = shortest[i];
                }
            }
            if (index == -1)
            {
                break;
            }
            visited[index] = true;
            for (int i = 0; i < n; i++)
            {
                if (!visited[i] && graph[index][i] != Integer.MAX_VALUE)
                {
                    shortest[i] = Math.min(shortest[i], min + graph[index][i]);
                }
            }
        }
        int delay = Integer.MIN_VALUE;
        // 若有节点没有被访问, 则返回 -1
        for (int i = 0; i < n; i++)
        {
            if (!visited[i])
            {
                return -1;
            }
            delay = Math.max(delay, shortest[i]);
        }
        return delay;
    }
}

package Y2021.M08.D6;

//https://leetcode-cn.com/problems/shortest-path-visiting-all-nodes/

import java.util.LinkedList;

public class Solution_3 {
    int res = 0;

    public int shortestPathLength(int[][] graph)
    {
        LinkedList<int[]> queue = new LinkedList<>();
        int[][] distance = new int[graph.length][1 << graph.length];

        for (int i = 0; i < graph.length; i++)
        {
            if (graph[i].length < 1)
                return 0;
            for(int j = 0; j < graph[i].length; j++)
            {
                int[] temp = new int[2];
                temp[0] = (int) Math.pow(2, i);
                temp[1] = i;
                queue.add(temp);
            }
        }
        bfs(queue, graph,distance);
        return res;
    }

    public void bfs(LinkedList<int[]> queue, int[][] graph, int[][] distance)
    {
        res++;
        LinkedList<int[]> nextQueue = new LinkedList<>();
        for (int[] e : queue)
        {
            for(int j = 0; j < graph[e[1]].length; j++)
            {
                int tempIndex = graph[e[1]][j];
                int[] temp = new int[2];
                int cover = e[0] | (1 << tempIndex);
                if(distance[tempIndex][cover] == 0)
                {
                    temp[0] = cover;
                    temp[1] = tempIndex;
                    nextQueue.add(temp);
                    distance[tempIndex][cover] = res;
                }
                if (temp[0] == ((1 << graph.length) - 1))
                {
                    return;
                }
            }
        }
        bfs(nextQueue, graph,distance);
    }
}

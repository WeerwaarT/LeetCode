package Y2021.M08.D5;

//https://leetcode-cn.com/problems/find-eventual-safe-states/

import java.util.*;

public class MySolution {
    int[] nodes;
    int[][] _graph;

    public List<Integer> eventualSafeNodes(int[][] graph)
    {
        nodes = new int[graph.length];
        _graph = graph;
        for (int i = 0; i < graph.length; ++i)
        {
            search(i);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nodes.length; ++i)
        {
            if (nodes[i] == 1)
            {
                list.add(i);
            }
        }
        return list;
    }

    private void search(int num)
    {
        if (nodes[num] != 0)
        {
            return;
        }
        Stack<Integer> toBeVisited = new Stack<>();
        for (int node : _graph[num])
        {
            toBeVisited.push(node);
        }
        nodes[num] = -1;
        while (!toBeVisited.empty())
        {
            Integer integer = toBeVisited.pop();
            if (nodes[integer] == -1)
            {
                nodes[num] = -1;
                return;
            }
            for (int i : _graph[integer])
            {
                search(i);
                if (nodes[i] == -1)
                {
                    nodes[integer] = -1;
                }
            }
            if (nodes[integer] == -1)
            {
                nodes[num] = -1;
                return;
            }
        }
        nodes[num] = 1;
    }

    public static void main(String[] args)
    {
        System.out.println(new MySolution().eventualSafeNodes(new int[][]{{1,2}, {2,3}, {5}, {0}, {5}, {}, {}}));
    }
}

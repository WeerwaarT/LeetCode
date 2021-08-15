package Y2021.M08.D2;

//https://leetcode-cn.com/problems/network-delay-time/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@Deprecated
public class MySolution {
    int[] _times;
    final Map<Integer, LinkedList<int[]>> map = new HashMap<>();

    public int networkDelayTime(int[][] times, int n, int k)
    {
        _times = new int[n + 1];
        for (int[] time : times)
        {
            if (time[1] == k)
            {
                continue;
            }
            LinkedList<int[]> linkedList = map.getOrDefault(time[0], new LinkedList<>());
            linkedList.addFirst(new int[]{time[1], time[2]});
            map.put(time[0], linkedList);
        }
        for (int[] path : map.getOrDefault(k, new LinkedList<>()))
        {
            dfs(path, 0);
        }
        int result = -1;
        for (int i = 1; i < n + 1; ++i)
        {
            if (_times[i] == 0 && i != k)
            {
                return -1;
            }
            result = Math.max(result, _times[i]);
        }
        return result;
    }

    private void dfs(int[] path, int previousTime)
    {
        int destination = path[0];
        int time = path[1];
        if (_times[destination] == 0)
        {
            _times[destination] = time + previousTime;
            for (int[] _path : map.getOrDefault(path[0], new LinkedList<>()))
            {
                dfs(_path, _times[destination]);
            }
        }
        else
        {
            int newTime = previousTime + time;
            if (newTime >= _times[destination])
            {
                return;
            }
            _times[destination] = newTime;
            for (int[] _path : map.getOrDefault(path[0], new LinkedList<>()))
            {
                dfs(_path, newTime);
            }
        }
    }
}

package Y2021.M08.D1;

//https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/

import java.util.PriorityQueue;
import java.util.Queue;

public class MySolution {
    public int[] kWeakestRows(int[][] mat, int k)
    {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) ->
        {
            if (o1[1] != (o2[1]))
            {
                return o1[1] - o2[1];
            }
            else
            {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < mat.length; ++i)
        {
            binarySearch(mat[i]);
            mat[i][0] = i;
            queue.add(mat[i]);
        }
        int[] results = new int[k];
        for (int i = 0; i < k; ++i)
        {
            results[i] = queue.remove()[0];
        }
        return results;
    }

    private void binarySearch(int[] ints)
    {
        int left = 0, right = ints.length - 1;
        while (left <= right)
        {
            int mid = left + ((right - left) >> 1);
            if (ints[mid] == 1)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        ints[1] = left;
    }
}

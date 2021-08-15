package Y2021.M08.D1;

//https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_2 {
    public int[] kWeakestRows(int[][] mat, int k)
    {
        int m = mat.length, n = mat[0].length;
        List<int[]> power = new ArrayList<>();
        for (int i = 0; i < m; ++i)
        {
            int l = 0, r = n - 1, pos = -1;
            while (l <= r)
            {
                int mid = (l + r) / 2;
                if (mat[i][mid] == 0)
                {
                    r = mid - 1;
                }
                else
                {
                    pos = mid;
                    l = mid + 1;
                }
            }
            power.add(new int[]{pos + 1, i});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) ->
        {
            if (pair1[0] != pair2[0])
            {
                return pair1[0] - pair2[0];
            }
            else
            {
                return pair1[1] - pair2[1];
            }
        });

        for (int[] pair : power)
        {
            pq.offer(pair);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; ++i)
        {
            ans[i] = pq.poll()[1];
        }
        return ans;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/solution/fang-zhen-zhong-zhan-dou-li-zui-ruo-de-k-xing-by-l/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

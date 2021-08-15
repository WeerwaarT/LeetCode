package Y2021.M07.D25;

//https://leetcode-cn.com/problems/restore-the-array-from-adjacent-pairs/

public class Solution_2 {
    public int[] restoreArray(int[][] adjacentPairs)
    {
        int allxor = 0;
        final int offset = 100_000;
        int[] sum = new int[200_001];   // sum的设计非常的巧妙

        for (int[] adj : adjacentPairs)
        {
            allxor ^= adj[0] ^ adj[1];
            sum[offset + adj[0]] += adj[1];
            sum[offset + adj[1]] += adj[0];
        }

        int lowBit = allxor & (-allxor);
        int x = 0;
        for (int[] adj : adjacentPairs)
        {
            x ^= ((adj[0] & lowBit) == 0) ? adj[0] : 0;
            x ^= ((adj[1] & lowBit) == 0) ? adj[1] : 0;
        }

        int[] res = new int[adjacentPairs.length + 1];
        res[0] = x;
        int pre = 0;
        for (int i = 0; i < res.length - 1; i++)
        {
            res[i + 1] = sum[offset + res[i]] - pre;  // 非常巧妙
            pre = res[i];
        }
        return res;
    }
}

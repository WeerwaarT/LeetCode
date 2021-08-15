package Y2021.M08.D1;

//https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/

import java.util.Arrays;

public class Solution_1 {
    public int[] kWeakestRows(int[][] mat, int k)
    {
        int[] list = new int[mat.length];
        int[] result = new int[k];
        for(int i = 0; i < mat.length; i++)
        {
            list[i] = count(mat[i]) * 100 + i;
        }
        Arrays.sort(list);
        for(int i = 0; i < k; i++)
        {
            result[i] = list[i] % 100;
        }
        return result;
    }

    public int count(int[] nums)
    {
        int sum=0;
        for(int n : nums)
        {
            if(n != 1)
            {
                break;
            }
            sum += n;
        }
        return sum;
    }
}

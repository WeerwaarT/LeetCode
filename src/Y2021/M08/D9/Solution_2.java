package Y2021.M08.D9;

//https://leetcode-cn.com/problems/super-ugly-number/

import java.util.Arrays;

public class Solution_2 {
    public int nthSuperUglyNumber(int n, int[] primes)
    {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int m = primes.length;
        int[] pointers = new int[m];
        Arrays.fill(pointers, 1);
        for (int i = 2; i <= n; i++)
        {
            int[] nums = new int[m];
            int minNum = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++)
            {
                nums[j] = dp[pointers[j]] * primes[j];
                minNum = Math.min(minNum, nums[j]);
            }
            dp[i] = minNum;
            for (int j = 0; j < m; j++)
            {
                if (minNum == nums[j])
                {
                    pointers[j]++;
                }
            }
        }
        return dp[n];
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/super-ugly-number/solution/chao-ji-chou-shu-by-leetcode-solution-uzff/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

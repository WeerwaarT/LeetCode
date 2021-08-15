package Y2021.M08.D8;

//https://leetcode-cn.com/problems/n-th-tribonacci-number/

public class MySolution {
    int[] dp = new int[38];

    {
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
    }

    public int tribonacci(int n)
    {
        if (n > 2 && dp[n] == 0)
        {
            dp[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        }
        return dp[n];
    }
}

package AlgorithmPractice.D13.Q191;

//https://leetcode-cn.com/problems/number-of-1-bits/

public class MySolution {
    public int hammingWeight(int n)
    {
        if (n == 0)
        {
            return 0;
        }
        int count;
        if (n > 0)
        {
            count = 0;
            while (n != 0)
            {
                if (n % 2 == 1)
                {
                    ++count;
                }
                n = n >> 1;
            }
        }
        else
        {
            count = 32;
            n = ~n;
            while (n != 0)
            {
                if (n % 2 == 1)
                {
                    --count;
                }
                n = n >> 1;
            }
        }
        return count;
    }
}

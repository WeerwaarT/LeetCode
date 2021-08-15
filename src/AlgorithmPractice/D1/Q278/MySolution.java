package AlgorithmPractice.D1.Q278;

//https://leetcode-cn.com/problems/first-bad-version/

public class MySolution {
    public int firstBadVersion(int n)
    {
        int left = 1, pivot;
        while (left <= n)
        {
            pivot = left + (n - left >> 1);
            if (isBadVersion(pivot))
            {
                n = pivot - 1;
            }
            else
            {
                left = pivot + 1;
            }
        }
        return left;
    }

    // ignore
    boolean isBadVersion(int version)
    {
        return version % 2 != 0;
    }
}

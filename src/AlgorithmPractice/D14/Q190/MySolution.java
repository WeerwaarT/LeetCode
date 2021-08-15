package AlgorithmPractice.D14.Q190;

//https://leetcode-cn.com/problems/reverse-bits/

public class MySolution {
    public int reverseBits(int n)
    {
        int result = 0;
        int count = 31;
        boolean isNegative = n < 0;
        if (isNegative)
        {
            n = ~n;
        }
        while (n != 0)
        {
            if (n % 2 == 1)
            {
                ++result;
            }
            result <<= 1;
            n >>= 1;
            --count;
        }
        while (count != 0)
        {
            result <<= 1;
            --count;
        }
        if (isNegative)
        {
            result = ~result;
        }
        return result;
    }

    public static void main(String[] args)
    {
        System.out.println(new MySolution().reverseBits(-3));
    }
}

package Y2021.M08.D8;

//https://leetcode-cn.com/problems/n-th-tribonacci-number/

public class Solution_2 {
    public int tribonacci(int n)
    {
        if (n == 0)
        {
            return 0;
        }
        if (n <= 2)
        {
            return 1;
        }
        int[][] q = {{1, 1, 1}, {1, 0, 0}, {0, 1, 0}};
        int[][] res = pow(q, n);
        return res[0][2];
    }

    public int[][] pow(int[][] a, int n)
    {
        int[][] ret = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        while (n > 0)
        {
            if ((n & 1) == 1)
            {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public int[][] multiply(int[][] a, int[][] b)
    {
        int[][] c = new int[3][3];
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j] + a[i][2] * b[2][j];
            }
        }
        return c;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/n-th-tribonacci-number/solution/di-n-ge-tai-bo-na-qi-shu-by-leetcode-sol-kn16/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

package Y2021.M08.D8;

//https://leetcode-cn.com/problems/n-th-tribonacci-number/

public class Solution_1 {
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
        int p, q = 0, r = 1, s = 1;
        for (int i = 3; i <= n; ++i)
        {
            p = q;
            q = r;
            r = s;
            s = p + q + r;
        }
        return s;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/n-th-tribonacci-number/solution/di-n-ge-tai-bo-na-qi-shu-by-leetcode-sol-kn16/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

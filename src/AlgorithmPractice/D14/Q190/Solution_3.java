package AlgorithmPractice.D14.Q190;

//https://leetcode-cn.com/problems/reverse-bits/

public class Solution_3 {
    public int reverseBits(int n)
    {
        int ans = 0;
        int cnt = 32;
        while (cnt-- > 0)
        {
            ans <<= 1;
            ans += (n & 1);
            n >>= 1;
        }
        return ans;
    }
}

//作者：AC_OIer
//链接：https://leetcode-cn.com/problems/reverse-bits/solution/yi-ti-san-jie-dui-cheng-wei-zhu-wei-fen-ub1hi/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

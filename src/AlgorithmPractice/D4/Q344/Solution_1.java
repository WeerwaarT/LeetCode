package AlgorithmPractice.D4.Q344;

//https://leetcode-cn.com/problems/reverse-string/

public class Solution_1 {
    public void reverseString(char[] s)
    {
        int l = 0;
        int r = s.length - 1;
        while (l < r)
        {
            s[l] ^= s[r];  //构造 a ^ b 的结果，并放在 a 中
            s[r] ^= s[l];  //将 a ^ b 这一结果再 ^ b ，存入b中，此时 b = a, a = a ^ b
            s[l] ^= s[r];  //a ^ b 的结果再 ^ a ，存入 a 中，此时 b = a, a = b 完成交换
            l++;
            r--;
        }
    }
}

//作者：carlsun-2
//链接：https://leetcode-cn.com/problems/reverse-string/solution/dai-ma-sui-xiang-lu-dai-ni-gao-ding-zi-f-jvr4/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

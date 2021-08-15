package AlgorithmPractice.D4.Q344;

//https://leetcode-cn.com/problems/reverse-string/

public class MySolution {
    public void reverseString(char[] s)
    {
        char temp;
        for (int i = 0; i < s.length >> 1; ++i)
        {
            temp = s[s.length - 1 - i];
            s[s.length - 1 - i] = s[i];
            s[i] = temp;
        }
    }
}

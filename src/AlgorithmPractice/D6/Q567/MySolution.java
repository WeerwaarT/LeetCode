package AlgorithmPractice.D6.Q567;

//https://leetcode-cn.com/problems/permutation-in-string/

public class MySolution {
    public boolean checkInclusion(String s1, String s2)
    {
        int[] s1Chars = new int[26];
        for (int c : s1.toCharArray())
        {
            ++s1Chars[c - 97];
        }
        int[] s1Copy = s1Chars.clone();
        char[] s2Chars = s2.toCharArray();
        int pointer = 0;
        while (pointer < s2Chars.length - s1.length() + 1)
        {
            if (s1Copy[s2Chars[pointer] - 97] != 0)
            {
                boolean inclusion = true;
                for (int i = pointer; i < pointer + s1.length(); ++i)
                {
                    if (s1Copy[s2Chars[i] - 97] != 0)
                    {
                        --s1Copy[s2Chars[i] - 97];
                    }
                    else
                    {
                        inclusion = false;
                        s1Copy = s1Chars.clone();
                        ++pointer;
                        break;
                    }
                }
                if (inclusion)
                {
                    return true;
                }
            }
            else
            {
                ++pointer;
            }
        }
        return false;
    }
}

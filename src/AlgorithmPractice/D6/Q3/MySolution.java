package AlgorithmPractice.D6.Q3;

//https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/

import java.util.HashSet;
import java.util.Set;

public class MySolution {
    public int lengthOfLongestSubstring(String s)
    {
        int count = 0, subCount = 0;
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        while (right < s.length())
        {
            if (set.contains(s.charAt(right)))
            {
                count = Math.max(count, subCount);
                set.remove(s.charAt(left));
                while (s.charAt(left++) != s.charAt(right))
                {
                    set.remove(s.charAt(left));
                    --subCount;
                }
            }
            else
            {
                ++subCount;
            }
            set.add(s.charAt(right));
            ++right;
        }
        return Math.max(count, subCount);
    }
}

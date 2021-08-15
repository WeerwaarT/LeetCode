package AlgorithmPractice.D6.Q3;

//https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/

public class Solution_2 {
    public int lengthOfLongestSubstring(String s)
    {
        int[] last = new int[128];
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++)
        {
            int index = s.charAt(i);
            start = Math.max(start, last[index]);
            res   = Math.max(res, i - start + 1);
            last[index] = i+1;
        }
        return res;
    }
}

package AlgorithmPractice.D6.Q567;

//https://leetcode-cn.com/problems/permutation-in-string/

public class Solution_2 {
    public boolean checkInclusion(String s1, String s2)
    {
        int n = s1.length(), m = s2.length();
        if (n > m)
        {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i)
        {
            --cnt[s1.charAt(i) - 'a'];
            ++cnt[s2.charAt(i) - 'a'];
        }
        int diff = 0;
        for (int c : cnt)
        {
            if (c != 0)
            {
                ++diff;
            }
        }
        if (diff == 0)
        {
            return true;
        }
        for (int i = n; i < m; ++i)
        {
            int x = s2.charAt(i) - 'a', y = s2.charAt(i - n) - 'a';
            if (x == y)
            {
                continue;
            }
            if (cnt[x] == 0)
            {
                ++diff;
            }
            ++cnt[x];
            if (cnt[x] == 0)
            {
                --diff;
            }
            if (cnt[y] == 0)
            {
                ++diff;
            }
            --cnt[y];
            if (cnt[y] == 0)
            {
                --diff;
            }
            if (diff == 0)
            {
                return true;
            }
        }
        return false;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/permutation-in-string/solution/zi-fu-chuan-de-pai-lie-by-leetcode-solut-7k7u/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

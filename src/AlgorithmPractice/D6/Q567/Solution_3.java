package AlgorithmPractice.D6.Q567;

//https://leetcode-cn.com/problems/permutation-in-string/

public class Solution_3 {
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
        }
        int left = 0;
        for (int right = 0; right < m; ++right)
        {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            while (cnt[x] > 0)
            {
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }
            if (right - left + 1 == n)
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

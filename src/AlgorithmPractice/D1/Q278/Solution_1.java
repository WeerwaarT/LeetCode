package AlgorithmPractice.D1.Q278;

//https://leetcode-cn.com/problems/first-bad-version/

public class Solution_1 {
    public int firstBadVersion(int n)
    {
        int left = 1, right = n;
        while (left < right) // 循环直至区间左右端点相同
        {
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (isBadVersion(mid))
            {
                right = mid; // 答案在区间 [left, mid] 中
            }
            else
            {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }

    // ignore
    boolean isBadVersion(int version)
    {
        return version % 2 != 0;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/first-bad-version/solution/di-yi-ge-cuo-wu-de-ban-ben-by-leetcode-s-pf8h/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

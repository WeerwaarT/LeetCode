package Y2021.M07.D23;

//https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/

public class Solution_1 {
    public boolean isCovered(int[][] ranges, int left, int right)
    {
        int[] diff = new int[52];   // 差分数组
        for (int[] range : ranges)
        {
            ++diff[range[0]];
            --diff[range[1] + 1];
        }
        // 前缀和
        int curr = 0;
        for (int i = 1; i <= 50; ++i)
        {
            curr += diff[i];
            if (i >= left && i <= right && curr <= 0)
            {
                return false;
            }
        }
        return true;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/solution/jian-cha-shi-fou-qu-yu-nei-suo-you-zheng-5hib/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

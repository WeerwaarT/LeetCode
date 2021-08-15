package Y2021.M08.D10;

//https://leetcode-cn.com/problems/arithmetic-slices/

public class Solution_1 {
    public int numberOfArithmeticSlices(int[] nums)
    {
        int n = nums.length;
        if (n == 1)
        {
            return 0;
        }

        int d = nums[0] - nums[1], t = 0;
        int ans = 0;
        // 因为等差数列的长度至少为 3，所以可以从 i=2 开始枚举
        for (int i = 2; i < n; ++i)
        {
            if (nums[i - 1] - nums[i] == d)
            {
                ++t;
            }
            else
            {
                d = nums[i - 1] - nums[i];
                t = 0;
            }
            ans += t;
        }
        return ans;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/arithmetic-slices/solution/deng-chai-shu-lie-hua-fen-by-leetcode-so-g7os/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

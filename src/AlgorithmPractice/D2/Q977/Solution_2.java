package AlgorithmPractice.D2.Q977;

//https://leetcode-cn.com/problems/squares-of-a-sorted-array/

public class Solution_2 {
    public int[] sortedSquares(int[] nums)
    {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j;)
        {
            if (nums[i] * nums[i] > nums[j] * nums[j])
            {
                ans[pos] = nums[i] * nums[i];
                ++i;
            }
            else
            {
                ans[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }
        return ans;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array/solution/you-xu-shu-zu-de-ping-fang-by-leetcode-solution/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

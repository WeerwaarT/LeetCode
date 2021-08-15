package Y2021.M07.D19;

//https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element/

import java.util.Arrays;

public class Solution_1 {
    public int maxFrequency(int[] nums, int k)
    {
        Arrays.sort(nums);
        int n = nums.length;
        long total = 0;
        int l = 0, res = 1;
        for (int r = 1; r < n; ++r)
        {
            total += (long) (nums[r] - nums[r - 1]) * (r - l);
            while (total > k)
            {
                total -= nums[r] - nums[l];
                ++l;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element/solution/zui-gao-pin-yuan-su-de-pin-shu-by-leetco-q5g9/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

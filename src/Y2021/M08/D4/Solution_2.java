package Y2021.M08.D4;

//https://leetcode-cn.com/problems/valid-triangle-number/

import java.util.Arrays;

public class Solution_2 {
    public int triangleNumber(int[] nums)
    {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; ++i)
        {
            int k = i;
            for (int j = i + 1; j < n; ++j)
            {
                while (k + 1 < n && nums[k + 1] < nums[i] + nums[j])
                {
                    ++k;
                }
                ans += Math.max(k - j, 0);
            }
        }
        return ans;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/valid-triangle-number/solution/you-xiao-san-jiao-xing-de-ge-shu-by-leet-t2td/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

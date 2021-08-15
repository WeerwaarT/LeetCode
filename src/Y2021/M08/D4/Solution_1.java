package Y2021.M08.D4;

//https://leetcode-cn.com/problems/valid-triangle-number/

import java.util.Arrays;

public class Solution_1 {
    public int triangleNumber(int[] nums)
    {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; ++i)
        {
            for (int j = i + 1; j < n; ++j)
            {
                int left = j + 1, right = n - 1, k = j;
                while (left <= right)
                {
                    int mid = (left + right) / 2;
                    if (nums[mid] < nums[i] + nums[j])
                    {
                        k = mid;
                        left = mid + 1;
                    }
                    else
                    {
                        right = mid - 1;
                    }
                }
                ans += k - j;
            }
        }
        return ans;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/valid-triangle-number/solution/you-xiao-san-jiao-xing-de-ge-shu-by-leet-t2td/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

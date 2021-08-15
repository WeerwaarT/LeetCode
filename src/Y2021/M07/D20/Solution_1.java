package Y2021.M07.D20;

//https://leetcode-cn.com/problems/minimize-maximum-pair-sum-in-array/

import java.util.Arrays;

public class Solution_1 {
    public int minPairSum(int[] nums)
    {
        int n = nums.length;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n / 2; ++i)
        {
            res = Math.max(res, nums[i] + nums[n - 1 - i]);
        }
        return res;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/minimize-maximum-pair-sum-in-array/solution/shu-zu-zhong-zui-da-shu-dui-he-de-zui-xi-cvll/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

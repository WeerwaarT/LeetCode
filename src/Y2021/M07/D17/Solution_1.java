package Y2021.M07.D17;

//https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/

class Solution_1 {
    public int maxSubArray(int[] nums)
    {
        int pre = 0, maxAns = nums[0];
        for (int x : nums)
        {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}

//动态规划
//
//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/solution/lian-xu-zi-shu-zu-de-zui-da-he-by-leetco-tiui/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

package Y2021.M08.D3;

//https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/

public class Solution_2 {
    public int findUnsortedSubarray(int[] nums)
    {
        int n = nums.length;
        int maxNum = Integer.MIN_VALUE, right = -1;
        int minNum = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++)
        {
            if (maxNum > nums[i])
            {
                right = i;
            }
            else
            {
                maxNum = nums[i];
            }
            if (minNum < nums[n - i - 1])
            {
                left = n - i - 1;
            }
            else
            {
                minNum = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/zui-duan-wu-xu-lian-xu-zi-shu-zu-by-leet-yhlf/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

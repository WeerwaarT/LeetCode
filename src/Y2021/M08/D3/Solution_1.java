package Y2021.M08.D3;

//https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/

import java.util.Arrays;

public class Solution_1 {
    public int findUnsortedSubarray(int[] nums)
    {
        if (isSorted(nums))
        {
            return 0;
        }
        int[] numsSorted = new int[nums.length];
        System.arraycopy(nums, 0, numsSorted, 0, nums.length);
        Arrays.sort(numsSorted);
        int left = 0;
        while (nums[left] == numsSorted[left])
        {
            left++;
        }
        int right = nums.length - 1;
        while (nums[right] == numsSorted[right])
        {
            right--;
        }
        return right - left + 1;
    }

    public boolean isSorted(int[] nums)
    {
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] < nums[i - 1])
            {
                return false;
            }
        }
        return true;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/zui-duan-wu-xu-lian-xu-zi-shu-zu-by-leet-yhlf/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

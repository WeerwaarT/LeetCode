package Y2021.M08.D4;

//https://leetcode-cn.com/problems/valid-triangle-number/

import java.util.Arrays;

public class Solution_3 {
    public int triangleNumber(int[] nums)
    {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++)
        {
            int index = i + 2;
            for (int j = i + 1; j < nums.length - 1; j++)
            {
                int target = nums[i] + nums[j];
                while (index < nums.length && nums[index] < target)
                {
                    index++;
                }
                res += Math.max(0, index - 1 - j);
            }
        }
        return res;
    }
}

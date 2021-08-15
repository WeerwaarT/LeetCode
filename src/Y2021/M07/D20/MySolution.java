package Y2021.M07.D20;

//https://leetcode-cn.com/problems/minimize-maximum-pair-sum-in-array/

import java.util.Arrays;

public class MySolution {
    public int minPairSum(int[] nums)
    {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < mid; ++i)
        {
            maxSum = Math.max(maxSum, nums[i] + nums[nums.length - 1 - i]);
        }
        return maxSum;
    }
}

package AlgorithmPractice.D14.Q136;

//https://leetcode-cn.com/problems/single-number/

public class MySolution {
    public int singleNumber_1(int[] nums)
    {
        int result = 0;
        for (int num : nums)
        {
            result ^= num;
        }
        return result;
    }

    public int singleNumber_2(int[] nums)
    {
        for (int i = 1; i < nums.length; ++i)
        {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}

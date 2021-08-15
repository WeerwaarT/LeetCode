package AlgorithmPractice.D3.Q283;

//https://leetcode-cn.com/problems/move-zeroes/

public class MySolution {
    public void moveZeroes(int[] nums)
    {
        if (nums.length < 2)
        {
            return;
        }
        int count = 0, indexToPut = 0;
        for (int i = 0; i < nums.length; ++i)
        {
            if (nums[i] == 0)
            {
                ++count;
            }
            else
            {
                nums[indexToPut] = nums[i];
                ++indexToPut;
            }
        }
        for (int i = nums.length - count; i < nums.length; ++i)
        {
            nums[i] = 0;
        }
    }
}

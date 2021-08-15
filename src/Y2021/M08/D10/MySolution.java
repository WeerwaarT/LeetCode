package Y2021.M08.D10;

//https://leetcode-cn.com/problems/arithmetic-slices/

public class MySolution {
    public int numberOfArithmeticSlices(int[] nums)
    {
        if (nums.length < 3)
        {
            return 0;
        }
        int difference = nums[0] - nums[1];
        int result = 0;
        int count = 0;
        for (int i = 1; i < nums.length - 1; ++i)
        {
            if (nums[i] - nums[i + 1] == difference)
            {
                ++count;
            }
            else
            {
                result += count * (count + 1) >> 1;
                count = 0;
                difference = nums[i] - nums[i + 1];
            }
        }
        if (count > 0)
        {
            result += (Math.pow(count, 2) + count) / 2;
        }
        return result;
    }

    public static void main(String[] args)
    {
        System.out.println(new MySolution().numberOfArithmeticSlices(new int[]{1,2,3,8,9,10}));
    }
}

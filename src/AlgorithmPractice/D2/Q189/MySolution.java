package AlgorithmPractice.D2.Q189;

//https://leetcode-cn.com/problems/rotate-array/

import java.util.Arrays;

public class MySolution {
    public void rotate(int[] nums, int k)
    {
        if (nums.length < 2)
        {
            return;
        }
        k %= nums.length;
        while (k-- != 0)
        {
            int tempLeft = nums[0], tempRight;
            for (int i = 0; i < nums.length - 1; ++i)
            {
                tempRight = nums[i + 1];
                nums[i + 1] = tempLeft;
                tempLeft = tempRight;
            }
            nums[0] = tempLeft;
        }
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{1,2,3,4,5};
        new MySolution().rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }
}

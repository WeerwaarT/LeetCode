package AlgorithmPractice.D3.Q167;

//https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/

public class MySolution {
    public int[] twoSum_1(int[] numbers, int target)
    {
        int left = 0, right = 1, n = numbers.length;
        while (true)
        {
            int sum = numbers[left] + numbers[right];
            if (sum == target)
            {
                break;
            }
            else
            {
                ++right;
            }
            if (right == n)
            {
                ++left;
                right = left + 1;
            }
        }
        return new int[]{left + 1, right + 1};
    }

    public int[] twoSum_2(int[] numbers, int target)
    {
        int left = 0, right = 1, n = numbers.length;
        while (true)
        {
            int sum = numbers[left] + numbers[right];
            if (sum == target)
            {
                break;
            }
            else if (sum > target)
            {
                ++left;
                right = left + 1;
            }
            else
            {
                ++right;
            }
            if (right == n)
            {
                ++left;
                right = left + 1;
            }
        }
        return new int[]{left + 1, right + 1};
    }
}

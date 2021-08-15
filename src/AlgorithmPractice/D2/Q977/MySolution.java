package AlgorithmPractice.D2.Q977;

//https://leetcode-cn.com/problems/squares-of-a-sorted-array/

import java.util.Arrays;

public class MySolution {
    public int[] sortedSquares_1(int[] nums)
    {
        for (int i = 0; i < nums.length; ++i)
        {
            nums[i] = (int) Math.pow(nums[i], 2);
        }
        Arrays.sort(nums);
        return nums;
    }

    public int[] sortedSquares_2(int[] nums)
    {
        int indexOfFirstNonNegative = binarySearchForFirstNonNegative(nums);
        if (indexOfFirstNonNegative != 0 && Math.abs(nums[indexOfFirstNonNegative - 1]) < nums[indexOfFirstNonNegative])
        {
            --indexOfFirstNonNegative;
        }
        int[] newNums = new int[nums.length];
        int left = 0, right = 1, count = 0;
        int numLeft = nums[indexOfFirstNonNegative] * nums[indexOfFirstNonNegative];
        int numRight = 0;
        boolean leftAvailable = true, rightAvailable = true;
        if ((indexOfFirstNonNegative + right) >= nums.length)
        {
            rightAvailable = false;
        }
        else
        {
            numRight = nums[indexOfFirstNonNegative + right] * nums[indexOfFirstNonNegative + right];
        }
        while (count < nums.length)
        {
            if (leftAvailable && rightAvailable)
            {
                if (numLeft < numRight)
                {
                    newNums[count] = numLeft;
                    ++left;
                    if (left > indexOfFirstNonNegative)
                    {
                        leftAvailable = false;
                    }
                    else
                    {
                        numLeft = nums[indexOfFirstNonNegative - left] * nums[indexOfFirstNonNegative - left];
                    }
                }
                else
                {
                    newNums[count] = numRight;
                    ++right;
                    if ((indexOfFirstNonNegative + right) >= nums.length)
                    {
                        rightAvailable = false;
                    }
                    else
                    {
                        numRight = nums[indexOfFirstNonNegative + right] * nums[indexOfFirstNonNegative + right];
                    }
                }
            }
            else if (leftAvailable)
            {
                newNums[count] = numLeft;
                ++left;
                if (left > indexOfFirstNonNegative)
                {
                    leftAvailable = false;
                }
                else
                {
                    numLeft = nums[indexOfFirstNonNegative - left] * nums[indexOfFirstNonNegative - left];
                }
            }
            else if (rightAvailable)
            {
                newNums[count] = numRight;
                ++right;
                if ((indexOfFirstNonNegative + right) >= nums.length)
                {
                    rightAvailable = false;
                }
                else
                {
                    numRight = nums[indexOfFirstNonNegative + right] * nums[indexOfFirstNonNegative + right];
                }
            }
            else
            {
                newNums[count] = numLeft;
            }
            ++count;
        }
        return newNums;
    }

    private int binarySearchForFirstNonNegative(int[] nums)
    {
        int left = 0, right = nums.length - 1;
        while (left < right)
        {
            int mid = left + (right - left >> 1);
            if (nums[mid] > -1)
            {
                right = mid;
            }
            else
            {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(new MySolution().sortedSquares_2(new int[]{-1, 2, 2})));
    }
}

package Y2021.M08.D7;

//https://leetcode-cn.com/problems/circular-array-loop/

public class MySolution {
    public boolean circularArrayLoop_1(int[] nums)
    {
        if (nums.length == 1)
        {
            return false;
        }
        for (int left = 0, right; left < nums.length; ++left)
        {
            int i = nums[left];
            if (i == 0)
            {
                continue;
            }
            boolean goodLength = false;
            right = left + i;
            if (right >= nums.length)
            {
                right %= nums.length;
            }
            if (right < 0)
            {
                right = right % nums.length;
                right = (right == 0)?nums.length - 1 : nums.length + right;
            }
            nums[left] = 0;
            if (i > 0)
            {
                for (int a = 0; a < nums.length - left && (nums[right] % nums.length > 0); ++a)
                {
                    right += nums[right] % nums.length;
                    if (right >= nums.length)
                    {
                        right %= nums.length;
                    }
                    goodLength = true;
                }
            }
            else
            {
                for (int a = 0; a < nums.length - left && (nums[right] % nums.length < 0); ++a)
                {
                    right += nums[right] % nums.length;
                    if (right < 0)
                    {
                        right = right % nums.length;
                        right = nums.length + right - 1;
                    }
                    goodLength = true;
                }
            }
            if (right == left && goodLength)
            {
                return true;
            }
        }
        return false;
    }

    public boolean circularArrayLoop_2(int[] nums)
    {
        for (int i = 0; i < nums.length; ++i)
        {
            if (nums[i] < 0)
            {
                nums[i] = nums[i] % nums.length;
                if (nums[i] == 0)
                {
                    nums[i] = i;
                }
            }
            else
            {
                nums[i] = (nums[i] + i) % nums.length;
            }
        }
        for (int i = 0; i < nums.length; ++i)
        {
            if (nums[i] < 0)
            {
                int index = i;
                for (int j = 0; j < nums.length - i; ++j)
                {
                    index += nums[i];
                    if (index < 0)
                    {
                        index += nums.length;
                    }
                    if (nums[index] >= 0)
                    {
                        break;
                    }
                }
                if (index == i)
                {
                    return true;
                }
            }
            else if (nums[i] < i)
            {
                int index = i;
                for (int j = 0; j < nums.length; ++j)
                {
                    index = nums[index];
                    if (index < 0)
                    {
                        break;
                    }
                    if (index == i)
                    {
                        return true;
                    }
                    if (index >= nums.length)
                    {
                        index %= nums.length;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        System.out.println(new MySolution().circularArrayLoop_2(new int[]{-1, 1}));
    }
}

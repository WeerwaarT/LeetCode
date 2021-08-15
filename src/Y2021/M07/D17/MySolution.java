package Y2021.M07.D17;

//https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/

class MySolution {
    public int maxSubArray(int[] nums)
    {
        if (nums.length == 1)
        {
            return nums[0];
        }
        int max = Math.max(nums[0], nums[1]);
        int[] list = new int[nums.length - 1];
        list[0] = nums[0] + nums[1];
        max = Math.max(max, list[0]);
        for (int i = 1; i < nums.length - 1; ++i)
        {
            max = Math.max(max, nums[i + 1]);
            list[i] = list[i - 1] + nums[i + 1];
            max = Math.max(max, list[i]);
        }
        for (int i = 1; i < nums.length - 1; ++i)
        {
            int num = nums[i - 1];
            if (num > 0)
            {
                for (int j = 0; j < nums.length - 1 - i; ++j)
                {
                    list[j] = list[j + 1] - num;
                }
            }
            else
            {
                for (int j = 0; j < nums.length - 1 - i; ++j)
                {
                    list[j] = list[j + 1] - num;
                    max = Math.max(max, list[j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args)
    {
        System.out.println(new MySolution().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}

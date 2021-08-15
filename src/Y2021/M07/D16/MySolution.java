package Y2021.M07.D16;

//https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/

public class MySolution {
    public int search(int[] nums, int target)
    {
        int count = 0;
        for(int i : nums)
        {
            if(i == target)
            {
                count++;
            }
        }
        return count;
    }
}

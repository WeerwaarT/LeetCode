package Y2021.M08.D10;

//https://leetcode-cn.com/problems/arithmetic-slices/

public class Solution_2 {
    public int numberOfArithmeticSlices(int[] nums)
    {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 2; )
        {
            int j = i, d = nums[i + 1] - nums[i];
            while (j + 1 < n && nums[j + 1] - nums[j] == d)
                j++;
            int len = j - i + 1;
            // a1：长度为 len 的子数组数量；an：长度为 3 的子数组数量
            int a1 = 1, an = len - 3 + 1;
            // 符合条件（长度大于等于3）的子数组的数量为「差值数列求和」结果
            int cnt = (a1 + an) * an / 2;
            ans += cnt;
            i = j;
        }
        return ans;
    }
}

//作者：AC_OIer
//链接：https://leetcode-cn.com/problems/arithmetic-slices/solution/gong-shui-san-xie-shuang-zhi-zhen-qiu-ji-ef1q/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

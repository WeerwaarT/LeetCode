package Y2021.M07.D19;

//https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element/

import java.util.Arrays;

public class Solution_2 {
    int[] nums, sum;
    int n, k;

    public int maxFrequency(int[] _nums, int _k)
    {
        nums = _nums;
        k = _k;
        n = nums.length;
        Arrays.sort(nums);
        sum = new int[n + 1];
        for (int i = 1; i <= n; i++)
            sum[i] = sum[i - 1] + nums[i - 1];
        int l = 0, r = n;
        while (l < r)
        {
            int mid = l + r + 1 >> 1;
            if (check(mid)) l = mid;
            else r = mid - 1;
        }
        return r;
    }

    boolean check(int len)
    {
        for (int l = 0; l + len - 1 < n; l++)
        {
            int r = l + len - 1;
            int cur = sum[r + 1] - sum[l];
            int t = nums[r] * len;
            if (t - cur <= k) return true;
        }
        return false;
    }
}

//作者：AC_OIer
//链接：https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element/solution/gong-shui-san-xie-cong-mei-ju-dao-pai-xu-kxnk/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

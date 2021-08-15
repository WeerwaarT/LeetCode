package Y2021.M07.D15;

//https://leetcode-cn.com/problems/maximum-element-after-decreasing-and-rearranging/

public class Solution_2 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr)
    {
        int n = arr.length;
        int[] cnt = new int[n + 1];
        for (int v : arr)
        {
            ++cnt[Math.min(v, n)];
        }
        int miss = 0;
        for (int i = 1; i <= n; ++i)
        {
            if (cnt[i] == 0)
            {
                ++miss;
            }
            else
            {
                miss -= Math.min(cnt[i] - 1, miss); // miss 不会小于 0，故至多减去 miss 个元素
            }
        }
        return n - miss;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/maximum-element-after-decreasing-and-rearranging/solution/jian-xiao-he-zhong-xin-pai-lie-shu-zu-ho-mzee/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

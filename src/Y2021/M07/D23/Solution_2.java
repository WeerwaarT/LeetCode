package Y2021.M07.D23;

//https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/

public class Solution_2 {
    public boolean isCovered(int[][] rs, int l, int r)
    {
        for (int i = l; i <= r; i++)
        {
            boolean ok = false;
            for (int[] cur : rs)
            {
                int a = cur[0], b = cur[1];
                if (a <= i && i <= b)
                {
                    ok = true;
                    break;
                }
            }
            if (!ok) return false;
        }
        return true;
    }
}

//作者：AC_OIer
//链接：https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/solution/gong-shui-san-xie-yi-ti-shuang-jie-mo-ni-j83x/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

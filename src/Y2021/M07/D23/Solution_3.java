package Y2021.M07.D23;

//https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/

public class Solution_3 {
    public boolean isCovered(int[][] ranges, int left, int right)
    {
        boolean[] flag = new boolean[51];
        for(int[] range : ranges)
        {
            int L = Math.max(range[0],left);
            int R = Math.min(range[1],right);
            for(int i = L; i <= R; i++)
            {
                flag[i] = true;
            }
        }
        for(int i = left; i <= right; i++)
        {
            if(!flag[i]) return false;
        }
        return true;
    }
}

//作者：LaoGanMaIsEverything
//链接：https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/solution/yi-ti-san-jie-bao-li-you-hua-chai-fen-by-w7xv/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

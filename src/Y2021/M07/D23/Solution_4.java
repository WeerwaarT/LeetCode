package Y2021.M07.D23;

//https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/

public class Solution_4 {
    public boolean isCovered(int[][] ranges, int left, int right)
    {
        int[] diff = new int[52];
        //对差分数组进行处理
        for (int[] range : ranges)
        {
            diff[range[0]]++;
            diff[range[1] + 1]--;
        }
        //根据差分数组处理前缀和，为理解方便单独定义sum，可以原地做
        int[] sum = new int[52];
        for(int i = 1; i <= 51; i++)
        {
            sum[i] = sum[i-1] + diff[i];
        }
        //从left到right判断是否满足sum > 0
        for(int i = left; i <= right; i++)
        {
            if(sum[i] <= 0) return false;
        }
        return true;
    }
}

//作者：LaoGanMaIsEverything
//链接：https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/solution/yi-ti-san-jie-bao-li-you-hua-chai-fen-by-w7xv/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

package AlgorithmPractice.D14.Q136;

//https://leetcode-cn.com/problems/single-number/

public class Solution_1 {
    public int singleNumber(int[] nums)
    {
        int single = 0;
        for (int num : nums)
        {
            single ^= num;
        }
        return single;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

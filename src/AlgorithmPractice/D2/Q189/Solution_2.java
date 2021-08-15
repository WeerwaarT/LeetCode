package AlgorithmPractice.D2.Q189;

//https://leetcode-cn.com/problems/rotate-array/

public class Solution_2 {
    public void rotate(int[] nums, int k)
    {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start)
        {
            int current = start;
            int prev = nums[start];
            do
            {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    public int gcd(int x, int y)
    {
        return y > 0 ? gcd(y, x % y) : x;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode-solution-nipk/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

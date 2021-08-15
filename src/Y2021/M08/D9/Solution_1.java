package Y2021.M08.D9;

//https://leetcode-cn.com/problems/super-ugly-number/

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution_1 {
    public int nthSuperUglyNumber(int n, int[] primes)
    {
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++)
        {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int prime : primes)
            {
                long next = curr * prime;
                if (seen.add(next))
                {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/super-ugly-number/solution/chao-ji-chou-shu-by-leetcode-solution-uzff/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

package AlgorithmPractice.D1.Q704;

//https://leetcode-cn.com/problems/binary-search/

public class Solution_1 {
    public int search(int[] nums, int target)
    {
        int pivot, left = 0, right = nums.length - 1;
        while (left <= right)
        {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) return pivot;
            if (target < nums[pivot]) right = pivot - 1;
            else left = pivot + 1;
        }
        return -1;
    }
}

//作者：LeetCode
//链接：https://leetcode-cn.com/problems/binary-search/solution/er-fen-cha-zhao-by-leetcode/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

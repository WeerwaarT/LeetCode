package Y2021.M07.D16;

//https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/

public class Solution_2 {
    public int search(int[] nums, int target)
    {
        int left = binarySearch(nums, target - 1);
        int right = binarySearch(nums, target);
        if (left == right)
            return 0;
        return right - left;
    }

    //如果没有，则返回应该存放的位置。如果有，
    //则返回比value大1的那个数字应该存放的下标
    private int binarySearch(int[] array, int value)
    {
        int lo = 0;
        int hi = array.length - 1;
        while (lo <= hi) {
            final int mid = (lo + hi) >>> 1;
            final int midVal = array[mid];
            if (midVal <= value) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}

//作者：sdwwld
//链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/solution/shu-ju-jie-gou-he-suan-fa-er-fen-fa-lian-5so4/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

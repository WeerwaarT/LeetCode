package Y2021.M08.D3;

//https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/

public class MySolution {
    public int findUnsortedSubarray(int[] nums)
    {
        int left = 0, right = 1, head = Integer.MAX_VALUE, tail = 0;
        while (right < nums.length)
        {
            if (nums[right] < nums[left])
            {
                if (head != 0)
                {
                    if (nums[right] < nums[0])
                    {
                        head = 0;
                    }
                    else
                    {
                        int _left = 1, _right = left;
                        while (_left < head && _left < _right)
                        {
                            int mid = _left + (_right - _left >> 1);
                            if (nums[mid] > nums[right])
                            {
                                _right = mid;
                            }
                            else
                            {
                                _left = mid + 1;
                            }
                        }
                        head = Math.min(_left, head);
                    }
                }
                tail = right + 1;
            }
            if (nums[right] > nums[left])
            {
                left = right;
            }
            ++right;
        }
        return (head == Integer.MAX_VALUE)?0:(tail - head);
    }
}

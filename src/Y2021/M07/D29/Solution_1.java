package Y2021.M07.D29;

//https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_1 {
    public List<Integer> pathInZigZagTree(int label)
    {
        int row = 1, rowStart = 1;
        while (rowStart * 2 <= label)
        {
            row++;
            rowStart *= 2;
        }
        if (row % 2 == 0)
        {
            label = getReverse(label, row);
        }
        List<Integer> path = new ArrayList<Integer>();
        while (row > 0)
        {
            if (row % 2 == 0)
            {
                path.add(getReverse(label, row));
            }
            else
            {
                path.add(label);
            }
            row--;
            label >>= 1;
        }
        Collections.reverse(path);
        return path;
    }

    public int getReverse(int label, int row)
    {
        return (1 << row - 1) + (1 << row) - 1 - label;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree/solution/er-cha-shu-xun-lu-by-leetcode-solution-ryx0/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

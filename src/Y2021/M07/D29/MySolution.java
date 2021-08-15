package Y2021.M07.D29;

//https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree/

import java.util.LinkedList;
import java.util.List;

public class MySolution {
    public List<Integer> pathInZigZagTree(int label)
    {
        LinkedList<Integer> result = new LinkedList<>();
        while (label != 1)
        {
            result.addFirst(label);
            int level = (int) (Math.log(label) / Math.log(2));
            label = label >> 1;
            label = (int) (Math.pow(2, level) + Math.pow(2, level - 1)) - 1 - label;
        }
        result.addFirst(1);
        return result;
    }

    public static void main(String[] args)
    {
        System.out.println(new MySolution().pathInZigZagTree(14));
    }
}

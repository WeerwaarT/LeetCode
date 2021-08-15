package Y2021.M07.D31;

//https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree/

import java.util.ArrayList;
import java.util.List;

public class Solution_1 {
    public List<List<Integer>> verticalTraversal(TreeNode root)
    {
        List<int[]> nodes = new ArrayList<>();
        dfs(root, 0, 0, nodes);
        nodes.sort((tuple1, tuple2) ->
        {
            if (tuple1[0] != tuple2[0])
            {
                return tuple1[0] - tuple2[0];
            }
            else if (tuple1[1] != tuple2[1])
            {
                return tuple1[1] - tuple2[1];
            }
            else
            {
                return tuple1[2] - tuple2[2];
            }
        });
        List<List<Integer>> ans = new ArrayList<>();
        int size = 0;
        int lastCol = Integer.MIN_VALUE;
        for (int[] tuple : nodes)
        {
            int col = tuple[0], value = tuple[2];
            if (col != lastCol)
            {
                lastCol = col;
                ans.add(new ArrayList<>());
                size++;
            }
            ans.get(size - 1).add(value);
        }
        return ans;
    }

    public void dfs(TreeNode node, int row, int col, List<int[]> nodes)
    {
        if (node == null)
        {
            return;
        }
        nodes.add(new int[]{col, row, node.val});
        dfs(node.left, row + 1, col - 1, nodes);
        dfs(node.right, row + 1, col + 1, nodes);
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree/solution/er-cha-shu-de-chui-xu-bian-li-by-leetcod-clsh/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

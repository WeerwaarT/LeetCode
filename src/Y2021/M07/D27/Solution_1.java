package Y2021.M07.D27;

//https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/

public class Solution_1 {
    int ans;
    int rootValue;

    public int findSecondMinimumValue(TreeNode root)
    {
        ans = -1;
        rootValue = root.val;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode node)
    {
        if (node == null)
        {
            return;
        }
        if (ans != -1 && node.val >= ans)
        {
            return;
        }
        if (node.val > rootValue)
        {
            ans = node.val;
        }
        dfs(node.left);
        dfs(node.right);
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/solution/er-cha-shu-zhong-di-er-xiao-de-jie-dian-bhxiw/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

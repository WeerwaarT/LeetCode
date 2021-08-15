package Y2021.M07.D27;

//https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode()
    {

    }

    TreeNode(int val)
    {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

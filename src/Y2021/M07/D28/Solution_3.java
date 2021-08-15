package Y2021.M07.D28;

//https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_3 {
    // 根据数据范围最多有 501 个点，每个点最多有 2 条无向边（两个子节点）
    int N = 510, M = N * 4;
    int[] he = new int[N], e = new int[M], ne = new int[M];
    int idx;
    boolean[] vis = new boolean[N];

    void add(int a, int b)
    {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode t, int k)
    {
        List<Integer> ans = new ArrayList<>();
        Arrays.fill(he, -1);
        dfs(root);
        vis[t.val] = true;
        find(t.val, k, 0, ans);
        return ans;
    }

    void find(int root, int max, int cur, List<Integer> ans)
    {
        if (cur == max)
        {
            ans.add(root);
            return ;
        }
        for (int i = he[root]; i != -1; i = ne[i])
        {
            int j = e[i];
            if (!vis[j])
            {
                vis[j] = true;
                find(j, max, cur + 1, ans);
            }
        }
    }

    void dfs(TreeNode root)
    {
        if (root == null) return;
        if (root.left != null)
        {
            add(root.val, root.left.val);
            add(root.left.val, root.val);
            dfs(root.left);
        }
        if (root.right != null)
        {
            add(root.val, root.right.val);
            add(root.right.val, root.val);
            dfs(root.right);
        }
    }
}

//作者：AC_OIer
//链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/solution/gong-shui-san-xie-yi-ti-shuang-jie-jian-x6hak/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

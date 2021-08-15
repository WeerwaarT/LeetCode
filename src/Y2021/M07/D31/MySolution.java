package Y2021.M07.D31;

//https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree/

import java.util.*;

public class MySolution {
    int last = 0;

    public List<List<Integer>> verticalTraversal(TreeNode root)
    {
        if (root == null)
        {
            return null;
        }
        Map<Integer, ArrayList<LinkedList<Integer>>> map = new HashMap<>();
        mapPut(map, root, 0, 0);
        List<List<Integer>> lists = new ArrayList<>();
        while (map.containsKey(last))
        {
            LinkedList<Integer> list = new LinkedList<>();
            for (LinkedList<Integer> linkedList : map.get(last))
            {
                Collections.sort(linkedList);
                for (int i : linkedList)
                {
                    list.addLast(i);
                }
            }
            lists.add(list);
            ++last;
        }
        return lists;
    }

    private void mapPut(Map<Integer, ArrayList<LinkedList<Integer>>> map, TreeNode node, int row, int column)
    {
        if (node == null)
        {
            return;
        }
        ArrayList<LinkedList<Integer>> arrayList = map.getOrDefault(column, new ArrayList<>());
        while (arrayList.size() - 1 < row)
        {
            arrayList.add(new LinkedList<>());
        }
        LinkedList<Integer> linkedList = arrayList.get(row);
        linkedList.addLast(node.val);
        map.put(column, arrayList);
        if (node.left != null)
        {
            mapPut(map, node.left, row + 1, column - 1);
            last = Math.min(last, column - 1);
        }
        mapPut(map, node.right, row + 1, column + 1);
    }
}

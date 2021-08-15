package Y2021.M07.D22;

//https://leetcode-cn.com/problems/copy-list-with-random-pointer/

import java.util.ArrayList;
import java.util.List;

public class MySolution {
    public Node copyRandomList(Node head)
    {
        if (head == null)
        {
            return null;
        }
        List<Node> visited = new ArrayList<>();
        Node temp = head;
        while (temp != null)
        {
            visited.add(temp);
            temp = temp.next;
        }
        int[] indexOfRandoms = new int[visited.size()];
        int[] values = new int[visited.size()];
        for (int i = 0; i < visited.size(); ++i)
        {
            if (head.random == null)
            {
                indexOfRandoms[i] = -1;
            }
            else
            {
                indexOfRandoms[i] = visited.indexOf(head.random);
            }
            values[i] = head.val;
            head = head.next;
        }
        Node myNode = new Node(values[0]);
        Node copyOfMyNode = myNode;
        for (int i = 1; i < visited.size(); ++i)
        {
            copyOfMyNode.next = new Node(values[i]);
            copyOfMyNode = copyOfMyNode.next;
        }
        copyOfMyNode = myNode;
        for (int i = 0; i < visited.size(); ++i)
        {
            if (indexOfRandoms[i] != -1)
            {
                Node copy = myNode;
                int index = indexOfRandoms[i];
                while (index-- != 0)
                {
                    copy = copy.next;
                }
                copyOfMyNode.random = copy;
            }
            copyOfMyNode = copyOfMyNode.next;
        }
        return myNode;
    }
}

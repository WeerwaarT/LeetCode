package Y2021.M07.D22;

//https://leetcode-cn.com/problems/copy-list-with-random-pointer/

public class Node
{
    int val;
    Node next;
    Node random;

    public Node(int val)
    {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

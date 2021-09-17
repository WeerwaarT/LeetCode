package Y2021.M08.D20;

//https://leetcode-cn.com/problems/reverse-string-ii/

public class MySolution {
    public String reverseStr(String s, int k)
    {
        boolean reverse = true;
        StringBuilder sb = new StringBuilder();
        int left = 0, right = k;
        while (true)
        {
            if (reverse)
            {
                sb.append(new StringBuilder(s.substring(left, right)).reverse());
            }
            else
            {
                
            }
            reverse = !reverse;
            right += k;
            if (right > s.length())
            {
                if (left > s.length())
                {
                    return sb.toString();
                }
                sb.append(new StringBuilder(s.substring(left)).reverse());
                return sb.toString();
            }

            right += 2 * k;
            left += 2 * k;
        }
    }

    private void swap(int start, int end, char[] chars)
    {
        while (start < end)
        {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            ++start;
            --end;
        }
    }

    public static void main(String[] args)
    {
        System.out.println(new MySolution().reverseStr("abcdefg", 2));
    }
}

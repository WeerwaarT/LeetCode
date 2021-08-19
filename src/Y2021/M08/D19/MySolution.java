package Y2021.M08.D19;

//https://leetcode-cn.com/problems/reverse-vowels-of-a-string/

public class MySolution {
    final int[] ints = new int[123];

    {
        ints['A'] = 1;
        ints['E'] = 1;
        ints['I'] = 1;
        ints['O'] = 1;
        ints['U'] = 1;
        ints['a'] = 1;
        ints['e'] = 1;
        ints['i'] = 1;
        ints['o'] = 1;
        ints['u'] = 1;
    }

    public String reverseVowels(String s)
    {
        int start = 0, end = s.length();
        char[] chars = s.toCharArray();
        while (start < end)
        {
            if (ints[chars[start]] == 1)
            {
                while (--end > start)
                {
                    if (ints[chars[end]] == 1)
                    {
                        char temp = chars[start];
                        chars[start] = chars[end];
                        chars[end] = temp;
                        break;
                    }
                }
            }
            ++start;
        }
        return new String(chars);
    }
}

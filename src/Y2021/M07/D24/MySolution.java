package Y2021.M07.D24;

//https://leetcode-cn.com/problems/latest-time-by-replacing-hidden-digits/

public class MySolution {
    public String maximumTime(String time)
    {
        char[] c = time.toCharArray();
        if (c.length != 5)
        {
            return null;
        }
        if (c[0] =='?')
        {
            if (c[1] == '?')
            {
                c[0] = '2';
                c[1] = '3';
            }
            else
            {
                switch (c[1])
                {
                    case '0':
                    case '1':
                    case '2':
                    case '3':   c[0] = '2'; break;
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':   c[0] = '1'; break;
                }
            }
        }
        else
        {
            if (c[1] == '?')
            {
                if (c[0] == '2')
                {
                    c[1] = '3';
                }
                else
                {
                    c[1] = '9';
                }
            }
        }
        if (c[3] == '?')
        {
            c[3] = '5';
        }
        if (c[4] == '?')
        {
            c[4] = '9';
        }
        return String.valueOf(c);
    }
}

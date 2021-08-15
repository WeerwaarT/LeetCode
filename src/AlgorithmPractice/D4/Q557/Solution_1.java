package AlgorithmPractice.D4.Q557;

//https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/

public class Solution_1 {
    public String reverseWords(String s)
    {
        int f=0,i;
        char[] cs=s.toCharArray();
        for(i=0;i<cs.length;i++)
        {
            if(cs[i]==' ')
            {
                re(cs,f,i-1);
                f=i+1;
            }
        }
        re(cs,f,i-1);
        return String.valueOf(cs);
    }

    public void re(char[] cs,int l,int r)
    {
        while(l<r)
        {
            char ch=cs[l];
            cs[l]=cs[r];
            cs[r]=ch;
            l++;
            r--;
        }
    }
}

package Y2021.M08.D19;

//https://leetcode-cn.com/problems/reverse-vowels-of-a-string/

public class Solution_1 {
    public String reverseVowels(String s)
    {
        int n = s.length();
        char[] arr = s.toCharArray();
        int i = 0, j = n - 1;
        while (i < j)
        {
            while (i < n && isVowel(arr[i]))
            {
                ++i;
            }
            while (j > 0 && isVowel(arr[j]))
            {
                --j;
            }
            if (i < j)
            {
                swap(arr, i, j);
                ++i;
                --j;
            }
        }
        return new String(arr);
    }

    public boolean isVowel(char ch)
    {
        return "aeiouAEIOU".indexOf(ch) < 0;
    }

    public void swap(char[] arr, int i, int j)
    {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string/solution/fan-zhuan-zi-fu-chuan-zhong-de-yuan-yin-2bmos/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

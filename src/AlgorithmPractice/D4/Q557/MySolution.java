package AlgorithmPractice.D4.Q557;

//https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/

public class MySolution {
    public String reverseWords(String s)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (String subString : s.split(" "))
        {
            stringBuilder.append(new StringBuilder(subString).reverse());
            stringBuilder.append(" ");
        }
        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
    }
}

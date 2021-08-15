package Y2021.M07.D18;

//https://leetcode-cn.com/problems/group-anagrams-lcci/

import java.util.*;

public class Solution_3 {
    static int[] nums = new int[26];

    static
    {
        for (int i = 2, idx = 0; idx != 26; i++)
        {
            boolean ok = true;
            for (int j = 2; j <= i / j; j++)
            {
                if (i % j == 0)
                {
                    ok = false;
                    break;
                }
            }
            if (ok) nums[idx++] = i;
        }
    }

    public List<List<String>> groupAnagrams(String[] ss)
    {
        List<List<String>> ans = new ArrayList<>();
        Map<Long, List<String>> map = new HashMap<>();
        for (String s : ss)
        {
            long cur = 1;
            for (char c : s.toCharArray())
            {
                cur *= nums[c - 'a'];
            }
            List<String> list = map.getOrDefault(cur, new ArrayList<>());
            list.add(s);
            map.put(cur, list);
        }
        for (long key : map.keySet()) ans.add(map.get(key));
        return ans;
    }
}

//质数分解唯一性
//事实上，我们还能使用「质数分解唯一性」性质，使用质数乘积代指某个「变位词」。
//
//具体的，我们可以先使用 static 代码块（确保只会发生一次）打表最小的 2626 个质数（任意 2626 个都可以，使用小的，乘积溢出风险低一点），这 2626 个质数分别对应了 2626 个字母。
//
//对于一个「变位词」而言，其对应的质数乘积必然相同。
//作者：AC_OIer
//链接：https://leetcode-cn.com/problems/group-anagrams-lcci/solution/gong-shui-san-xie-tong-ji-bian-wei-ci-de-0iqe/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

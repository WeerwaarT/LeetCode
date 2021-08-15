package Y2021.M07.D18;

//https://leetcode-cn.com/problems/group-anagrams-lcci/

import java.util.*;

public class Solution_1 {
    public List<List<String>> groupAnagrams(String[] strings)
    {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}

//方法一：排序
//由于互为变位词的两个字符串包含的字母相同，因此对两个字符串分别进行排序之后得到的字符串一定是相同的，故可以将排序之后的字符串作为哈希表的键。
//
//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/group-anagrams-lcci/solution/bian-wei-ci-zu-by-leetcode-solution-g2a8/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

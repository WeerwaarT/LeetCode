package Y2021.M07.D18;

//https://leetcode-cn.com/problems/group-anagrams-lcci/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_2 {
    public List<List<String>> groupAnagrams(String[] strings)
    {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strings)
        {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++)
            {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++)
            {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}

//方法二：计数
//由于互为变位词的两个字符串包含的字母相同，因此两个字符串中的相同字母出现的次数一定是相同的，故可以将每个字母出现的次数使用字符串表示，作为哈希表的键。
//
//由于字符串只包含小写字母，因此对于每个字符串，可以使用长度为 2626 的数组记录每个字母出现的次数。需要注意的是，在使用数组作为哈希表的键时，不同语言的支持程度不同，因此不同语言的实现方式也不同。
//
//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/group-anagrams-lcci/solution/bian-wei-ci-zu-by-leetcode-solution-g2a8/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

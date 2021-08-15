package Y2021.M07.D18;

//https://leetcode-cn.com/problems/group-anagrams-lcci/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MySolution {
    public List<List<String>> groupAnagrams(String[] strings)
    {
        List<List<String>> lists = new ArrayList<>();
        ArrayList<Integer> indexList = new ArrayList<>(strings.length);
        int i = 0;
        do
        {
            indexList.add(i);
        } while (++i < strings.length);
        while (!indexList.isEmpty())
        {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(strings[indexList.get(0)]);
            if (indexList.size() == 1)
            {
                lists.add(arrayList);
                break;
            }
            int x = 1;
            char[] tempArray = strings[indexList.get(0)].toCharArray();
            Arrays.sort(tempArray);
            String tempString = Arrays.toString(tempArray);
            while (x < indexList.size())
            {
                if (arrayList.get(0).length() == strings[indexList.get(x)].length() &&
                    checkProperty(tempString, strings[indexList.get(x)]))
                {
                    arrayList.add(strings[indexList.get(x)]);
                    indexList.remove(x);
                    continue;
                }
                ++x;
            }
            indexList.remove(0);
            lists.add(arrayList);
        }
        return lists;
    }

    private boolean checkProperty(String a, String b)
    {
        char[] tempArrayB = b.toCharArray();
        Arrays.sort(tempArrayB);
        return (a.compareTo(Arrays.toString(tempArrayB)) == 0);
    }

    public static void main(String[] args)
    {
        System.out.println(new MySolution().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}

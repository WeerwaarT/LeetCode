package Y2021.M07.D30;

//https://leetcode-cn.com/problems/excel-sheet-column-number/

public class Solution_1 {
    public int titleToNumber(String columnTitle)
    {
        int number = 0;
        int multiple = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int k = columnTitle.charAt(i) - 'A' + 1;
            number += k * multiple;
            multiple *= 26;
        }
        return number;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/excel-sheet-column-number/solution/excelbiao-lie-xu-hao-by-leetcode-solutio-r29l/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

package Y2021.M08.D15;

//https://leetcode-cn.com/problems/out-of-boundary-paths/

public class Solution_2 {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn)
    {
        final int MOD = 1000000007;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int outCounts = 0;
        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;
        for (int i = 0; i < maxMove; i++)
        {
            int[][] dpNew = new int[m][n];
            for (int j = 0; j < m; j++)
            {
                for (int k = 0; k < n; k++)
                {
                    int count = dp[j][k];
                    if (count > 0)
                    {
                        for (int[] direction : directions)
                        {
                            int j1 = j + direction[0], k1 = k + direction[1];
                            if (j1 >= 0 && j1 < m && k1 >= 0 && k1 < n) {
                                dpNew[j1][k1] = (dpNew[j1][k1] + count) % MOD;
                            }
                            else
                            {
                                outCounts = (outCounts + count) % MOD;
                            }
                        }
                    }
                }
            }
            dp = dpNew;
        }
        return outCounts;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/out-of-boundary-paths/solution/chu-jie-de-lu-jing-shu-by-leetcode-solut-l9dw/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

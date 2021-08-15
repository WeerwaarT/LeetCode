package Y2021.M08.D15;

//https://leetcode-cn.com/problems/out-of-boundary-paths/

public class Solution_4 {
    int res,row,col;
    int[][][] v;

    public int dfs(int x,int y,int m)
    {
        if (x < 0 || x >= row || y < 0 || y >= col)
            return 1;
        if (m < 0 || (m < x + 1 && m < y + 1 && m < row - x && m < col - y))
            return 0;

        if (v[x][y][m] != 0)
            return (v[x][y][m]);
        res = 0;
        int t = m - 1;
        res = (res + dfs(x, y + 1, t)) % 1000000007;
        res = (res + dfs(x, y - 1, t)) % 1000000007;
        res = (res + dfs(x - 1, y, t)) % 1000000007;
        res = (res + dfs(x + 1, y, t)) % 1000000007;
        v[x][y][m] = res;
        return res;
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn)
    {
        res = 0;
        row = m;
        col = n;
        v = new int[m][n][maxMove + 1];
        return dfs(startRow, startColumn, maxMove);
    }
}

package Y2021.M08.D15;

//https://leetcode-cn.com/problems/out-of-boundary-paths/

@Deprecated // Timeout
public class MySolution {
    private final int left_top_bound = 0;
    private int bottom_bound;
    private int right_bound;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn)
    {
        bottom_bound = m - 1;
        right_bound = n - 1;
        return search(maxMove, startRow, startColumn) % (1_000_000_000 + 7);
    }

    private int search(int move, int row, int column)
    {
        if (--move < 0)
        {
            return 0;
        }
        return searchTop(move, row - 1, column)
                + searchBottom(move, row + 1, column)
                + searchLeft(move, row, column - 1)
                + searchRight(move, row, column + 1);
    }

    private int searchTop(int move, int row, int column)
    {
        if (row < left_top_bound)
        {
            return 1;
        }
        if (move > 0)
        {
            return search(move, row, column) % (1_000_000_000 + 7);
        }
        return 0;
    }

    private int searchBottom(int move, int row, int column)
    {
        if (row > bottom_bound)
        {
            return 1;
        }
        if (move > 0)
        {
            return search(move, row, column) % (1_000_000_000 + 7);
        }
        return 0;
    }

    private int searchLeft(int move, int row, int column)
    {
        if (column < left_top_bound)
        {
            return 1;
        }
        if (move > 0)
        {
            return search(move, row, column) % (1_000_000_000 + 7);
        }
        return 0;
    }

    private int searchRight(int move, int row, int column)
    {
        if (column > right_bound)
        {
            return 1;
        }
        if (move > 0)
        {
            return search(move, row, column) % (1_000_000_000 + 7);
        }
        return 0;
    }

    public static void main(String[] args)
    {
        System.out.println(new MySolution().findPaths(1, 3, 3, 0, 1));
    }
}

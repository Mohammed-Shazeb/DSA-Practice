public class SubArrGrid {
    private int[][] pre; // prefix sum grid (rows+1 x cols+1)

    public SubArrGrid(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            pre = new int[1][1];
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        pre = new int[rows + 1][cols + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                pre[i][j] = matrix[i - 1][j - 1] + pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // assume 0-based inclusive coordinates and valid bounds
        return pre[row2 + 1][col2 + 1] - pre[row1][col2 + 1] - pre[row2 + 1][col1] + pre[row1][col1];
        // for 1 based indexing, just remove the +1s
        // return pre[row2][col2] - pre[row1 - 1][col2] - pre[row2][col1 - 1] + pre[row1 - 1][col1 - 1];
    }

    public static void main(String[] args) {
        int grid[][] = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        SubArrGrid obj = new SubArrGrid(grid);
        /*
         * 1 3 6
         * 5 12 21
         * 12 27 45
         */
        System.out.println(obj.sumRegion(0, 0, 2, 2)); // full grid -> 45
        System.out.println(obj.sumRegion(0, 0, 0, 0)); // single cell -> 1
        System.out.println(obj.sumRegion(1, 1, 2, 2)); // subgrid -> 5+6+8+9 = 28
    }
}

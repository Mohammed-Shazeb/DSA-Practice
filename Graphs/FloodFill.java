package Graphs;

public class FloodFill {
    public void helper(int[][] image, int sr, int sc, int color, boolean[][] vis, int originalColor, int[][] res) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || vis[sr][sc]
                || image[sr][sc] != originalColor) {
            return;
        }
        vis[sr][sc] = true;
        res[sr][sc] = color;

        // left
        helper(image, sr, sc - 1, color, vis, originalColor, res);

        // right
        helper(image, sr, sc + 1, color, vis, originalColor, res);

        // up
        helper(image, sr - 1, sc, color, vis, originalColor, res);
        // down
        helper(image, sr + 1, sc, color, vis, originalColor, res);

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        int res[][] = new int[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                res[i][j] = image[i][j];
            }
        }

        helper(image, sr, sc, color, vis, image[sr][sc], res);
        return res;
    }

    public static void main(String[] args) {

    }
}

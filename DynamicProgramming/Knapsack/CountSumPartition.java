package DynamicProgramming.Knapsack;

public class CountSumPartition {
    public static int countPartitions(int val[], int target) {
        int n = val.length;
        int dp[][] = new int[n + 1][target + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                int v = val[i - 1];
                if (v <= j) {
                    dp[i][j] = dp[i - 1][j - v] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        // print(dp);
        return dp[n][target];
    }
    public static void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int val[] = { 2, 3, 5, 6, 8, 10 };
        int target = 10;
        int res = countPartitions(val, target);
        System.out.println(res);
    }
}

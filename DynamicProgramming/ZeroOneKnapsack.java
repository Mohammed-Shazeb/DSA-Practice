package DynamicProgramming;

public class ZeroOneKnapsack {
    public static int knapsackUsingRec(int val[], int wt[], int W, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }

        if (wt[n - 1] <= W) {
            // include the item
            int includeItem = val[n - 1] + knapsackUsingRec(val, wt, W - wt[n - 1], n - 1);
            // exclude the item
            int excludeItem = knapsackUsingRec(val, wt, W, n - 1);
            return Math.max(includeItem, excludeItem);
        } else {
            // exclude the item
            return knapsackUsingRec(val, wt, W, n - 1);
        }
    }

    public static int knapsackUsingMemo(int val[], int wt[], int W, int n, int dp[][]) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if(dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n - 1] <= W) {
            // include the item
            int includeItem = val[n - 1] + knapsackUsingMemo(val, wt, W - wt[n - 1], n - 1, dp);
            // exclude the item
            int excludeItem = knapsackUsingMemo(val, wt, W, n - 1, dp);
            dp[n][W] = Math.max(includeItem, excludeItem);
            return dp[n][W];
        } else {
            // exclude the item
            dp[n][W] = knapsackUsingMemo(val, wt, W, n - 1, dp);
            return dp[n][W];
        }
    }
    
    public static void print(int dp[][]) {
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static int knapSackUsingTabulation(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];
        for(int i=0; i<dp.length; i++) {  // 0th col
            dp[i][0] = 0;
        }
        for(int i=0; i<dp[0].length; i++) {  // 0th row
            dp[0][i] = 0;
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<W+1; j++) {
                int v = val[i-1];
                int w = wt[i-1];

                if(w <= j) {
                    int includeProfit = v + dp[i-1][j-w];
                    int excludeProfit = dp[i-1][j];
                    dp[i][j] = Math.max(includeProfit, excludeProfit);
                } else {
                    int excludeProfit = dp[i-1][j];
                    dp[i][j] = excludeProfit;
                }
            }
        }
        print(dp);
        return dp[n][W];
    }
    
    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                dp[i][j] = -1; 
            }
        }
        int maxValue = knapsackUsingRec(val, wt, W, n);
        System.out.println("The maximum value in Knapsack (Rec) is: " + maxValue);

        int maxValueMemo = knapsackUsingMemo(val, wt, W, n, dp);
        System.out.println("The maximum value in Knapsack (Memo) is: " + maxValueMemo);

        int maxValueTabulation = knapSackUsingTabulation(val, wt, W);
        System.out.println("The maximum value in Knapsack (Tab) is: " + maxValueTabulation);
    }
}

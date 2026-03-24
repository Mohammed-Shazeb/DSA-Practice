package DynamicProgramming.Knapsack;

public class CountTheNumOfSubsetWtihGivenDiff {
    
    public static int countPartitions(int val[], int target) {
        int n = val.length;
        int dp[][] = new int[n + 1][target + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<target+1; j++) {
                int v= val[i-1];

                if(v<=j) {
                    dp[i][j] = dp[i-1][j-v] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }
    

    public static int countSubsetWithGivenDiff(int val[], int diff) {
        int sum = 0;
        for (int i = 0; i < val.length; i++) sum += val[i];

        int target = (sum + diff) / 2;

        return countPartitions(val, target);
    }
    public static void main(String[] args) {
        int val[] = { 1, 1, 2, 3 };
        int diff = 1;
        int res = countSubsetWithGivenDiff(val, diff);
        System.out.println(res);
    }
}

package DynamicProgramming.Knapsack;

public class TargetSumSubset {
    public static boolean targetSumSubset(int val[], int target) {
        int n = val.length;
        boolean dp[][] = new boolean[n + 1][target + 1];
        
        // initialize first column as true
        for(int i=0; i<n+1; i++) {
            dp[i][0] = true; 
        }
        
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<target+1; j++) {
                int v = val[i-1];
                //include
                if(v<=j && dp[i-1][j-v] == true) {
                    dp[i][j] = true;
                } else if(dp[i-1][j] == true) { //exclude
                    dp[i][j] = true;    
                }
            }
        }
        
        print(dp);
        return dp[n][target]; 
    }
    private static void print(boolean dp[][]) {
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int val[] = {4, 2, 7, 1, 3};
        int target = 10;
        boolean res = targetSumSubset(val, target);
        System.out.println("Is there a subset with the given target sum? " + res);
    }
}

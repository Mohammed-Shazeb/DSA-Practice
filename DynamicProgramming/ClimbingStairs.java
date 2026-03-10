package DynamicProgramming;

public class ClimbingStairs {
    public static int climbStairsUsingTabulation(int n) {
        if (n <= 1) {
            return 1;
        }
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int climbStairsUsingTabulationBut3Climbed(int n) {
    if (n < 0) return 0;
    if (n <= 1) return 1;

    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }
    return dp[n];
}

    public static int climbStairsUsingRecAndMemo(int n, int[] memo) {
        if (n <= 1) {
            return 1;
        }
        if (memo[n] != 0)
            return memo[n]; // already computed
        memo[n] = climbStairsUsingRecAndMemo(n - 1, memo) + climbStairsUsingRecAndMemo(n - 2, memo);
        return memo[n];
    }

    public static int climbStairsUsingRec(int n) {
        if (n <= 1) {
            return 1;
        }
        return climbStairsUsingRec(n - 1) + climbStairsUsingRec(n - 2);

    }

    public static int climbStairsOptimized(int n) {
        if (n <= 1)
            return 1;

        int prev2 = 1; // ways to reach step 0
        int prev1 = 1; // ways to reach step 1

        for (int i = 2; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public static void main(String[] args) {
        int resultTabulation = climbStairsUsingTabulation(5);
        System.out.println("Using Tabulation: " + resultTabulation);

        int n = 5;
        int memo[] = new int[n + 1];
        int resultMemoization = climbStairsUsingRecAndMemo(n, memo);
        System.out.println("Using Recursion and Memoization: " + resultMemoization);

        int resultRecursion = climbStairsUsingRec(5);
        System.out.println("Using Simple Recursion: " + resultRecursion);

        int resultOptimized = climbStairsOptimized(5);
        System.out.println("Using Optimized Space: " + resultOptimized);
    }
}

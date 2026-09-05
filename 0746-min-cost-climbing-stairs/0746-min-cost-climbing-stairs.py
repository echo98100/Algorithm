class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:

        dp = [0 for _ in range(1000)]

        dp[0] = cost[0]
        dp[1] = cost[1]

        n = len(cost)

        for i in range(2, len(cost)):
            dp[i] = min(dp[i-1], dp[i-2]) + cost[i]

        return min(dp[n-1], dp[n-2])
        
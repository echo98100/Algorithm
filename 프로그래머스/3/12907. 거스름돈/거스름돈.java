class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for(int now : money){

            for(int i = now; i <= n; i++){
                dp[i] += dp[i-now];
                dp[i] %= 1000000007;
            }
        }
        
        return dp[n];
    }
}
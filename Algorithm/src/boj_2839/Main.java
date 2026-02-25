package boj_2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int MAX = 5001;
        int[] dp = new int[N+1];
        Arrays.fill(dp, MAX);

        dp[3] = 1;
        if(N==3) {
            System.out.println(dp[3]);
            return;
        }
        if(N==4) {
            System.out.println(-1);
            return;
        }
        dp[5] = 1;
        if(N==5) {
            System.out.println(dp[5]);
            return;
        }

        for(int i = 6; i <= N; i++) {

            if(dp[i-5] != MAX || dp[i-3] != MAX) {
                dp[i] = Math.min(dp[i-5] + 1, dp[i-3] + 1);
            }

        }
        if(dp[N] == MAX) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }

    }
}

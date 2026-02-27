package boj_9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int len1 = s1.length(); // r
        int len2 = s2.length(); // c

        int[][] dp = new int[len1+1][len2+1];

        for(int r = 1; r <= len1; r++) {
            for(int c = 1; c <= len2; c++) {

                if(s2.charAt(c-1) == s1.charAt(r-1)){
                    dp[r][c] = dp[r-1][c-1] + 1;
                } else {
                    dp[r][c] = Math.max(dp[r-1][c], dp[r][c-1]);
                }
            }
        }

        System.out.println(dp[len1][len2]);

    }
}

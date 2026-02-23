package boj_1312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int remain = A % B;
        int digit = 0;

        for(int i = 0; i < N; i++) {
            remain *= 10;
            digit = remain / B;
            remain %= B;
        }
        System.out.println(digit);
    }
}

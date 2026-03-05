package boj_32749;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        String num = br.readLine();

        int size = 1 << (N - T);
        int count = 1 << T;

        int index = 0;
        String max = "";
        for(int i = 0; i < count; i++) {

            String number = num.substring(index, index + size);
            index += size;

            if(max.equals("")) max = number;
            else if(number.compareTo(max) > 0){
                max = number;
            }
        }
        System.out.println(max);

    }
}

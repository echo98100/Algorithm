package boj_9742;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int totalCnt;
    static int location;
    static boolean[] visited;
    static char[] perm;

    static String answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line = "";

        String word = "";
        location = 0;

        while((line = br.readLine()) != null) {
            st = new StringTokenizer(line);

            word = st.nextToken();
            location = Integer.parseInt(st.nextToken());

            totalCnt = 0;
            visited = new boolean[word.length()];
            perm = new char[word.length()];

            permutation(word, 0);

            if(totalCnt < location) {
                answer = "No permutation";
            }
            System.out.println(word + " " + location + " = " + answer);
        }
    }

    public static void permutation(String str, int cnt) {

        if(cnt == str.length()) {
            totalCnt++;
            if(totalCnt == location) {
                answer = new String(perm);
            }
            return;
        }

        for(int i = 0; i < str.length(); i++) {

            if(!visited[i]) {
                visited[i] = true;
                perm[cnt] = str.charAt(i);
                permutation(str, cnt+1);
                visited[i] = false;
            }

        }

    }

}

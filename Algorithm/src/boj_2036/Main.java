package boj_2036;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> negative = new ArrayList<>();
        List<Integer> positive = new ArrayList<>();

        int zero = 0;
        long score = 0;

        for(int i = 0; i < n; i++){
            int now = sc.nextInt();
            if(now == 1) {
                score++;
            } else if (now == 0) {
                zero++;
            } else if (now < 0) {
                negative.add(now);
            } else {
                positive.add(now);
            }
        }

        Collections.sort(negative);
        Collections.sort(positive);
        Collections.reverse(positive);

        // 음수가 짝수개 일 때
        if(negative.size()%2==0) {
            for(int i = 0; i < negative.size(); i+=2) {
                score += (long)negative.get(i) * negative.get(i+1);
            }
        } else { // 음수가 홀수개 일 때

            for(int i = 0; i < negative.size()-1; i+=2) {
                score+= (long)negative.get(i) * negative.get(i+1);
            }
            if(zero == 0) {
                score += (long)negative.get(negative.size() - 1);
            }
        }

        // 양수가 짝수개 일 때
        if(positive.size()%2==0) {
            for(int i = 0; i < positive.size(); i+=2) {
                score += (long)positive.get(i) * positive.get(i+1);
            }
        } else { // 양수가 홀수개 일 때

            for(int i = 0; i < positive.size()-1; i+=2) {
                score+= (long)positive.get(i) * positive.get(i+1);
            }
            score += (long)positive.get(positive.size()-1);
        }



        System.out.println(score);

    }
}

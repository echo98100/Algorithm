package boj_4335;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int low = 1;
        int high = 10;

        while(true){
            int now = sc.nextInt();
            sc.nextLine();
            if(now == 0) break;

            String answer = sc.nextLine();

            if(answer.equals("too high")) {
                high = Math.min(high, now-1);
            } else if(answer.equals("too low")) {
                low = Math.max(low,now+1);
            } else if(answer.equals("right on")) {
                if(now >= low && now <= high) {
                    System.out.println("Stan may be honest");
                } else {
                    System.out.println("Stan is dishonest");
                }
                low = 1;
                high = 10;
            }


        }


    }
}

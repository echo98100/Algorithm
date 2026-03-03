package boj_1339;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {

            String str = sc.next();
            for(int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                int value = (int)Math.pow(10, str.length()-1-j);
                map.put(c, map.getOrDefault(c,0) + value);
            }
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list,Collections.reverseOrder());

        int num = 9;
        int answer = 0;

        for(int i : list) {
            answer += i*num--;
        }
        System.out.println(answer);
    }
}

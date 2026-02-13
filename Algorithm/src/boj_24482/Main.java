package boj_24482;

import java.util.*;
//인접 리스트 방식
public class Main {

    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] depth;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //정점의 수
        int M = sc.nextInt(); //간선의 수
        int R = sc.nextInt(); //시작 정점

        graph = new ArrayList[N+1];
        for(int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();

            graph[parent].add(child);
            graph[child].add(parent);
        }

        // 내림차순 방문이 문제에 명시되어있으므로 뒤집기
        for(int i = 1; i <= N; i++) {
            graph[i].sort(Collections.reverseOrder());
        }

        visited = new boolean[N+1];
        depth = new int[N+1];
        Arrays.fill(depth, -1);

        dfs(R, 0);

        for(int i = 1; i <= N; i++) {
            System.out.println(depth[i]);
        }

    }

    public static void dfs(int v, int d) {

        visited[v] = true;
        depth[v] = d;

        for(int next : graph[v]) {
            if(!visited[next]){
                dfs(next, d+1);
            }
        }

    }
}


// 인접 배열.. -> N,M이 커서 메모리 초과
//public class Main {
//
//    static int N, M, R;
//    static int[][] graph;
//    static boolean[] visited;
//
//    static int[] depth;
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        N = sc.nextInt(); //정점의 수
//        M = sc.nextInt(); //간선의 수
//        R = sc.nextInt(); //시작 정점
//
//        //인접 배열로 풀이 (정점이 1번부터 시작하므로 N+1)
//        graph = new int[N+1][N+1];
//        visited = new boolean[N+1];
//
//        for(int i = 0; i < M; i++) {
//            int parent = sc.nextInt();
//            int child = sc.nextInt();
//
//            graph[parent][child] = 1;
//            graph[child][parent] = 1;
//        }
//
//        depth = new int[N+1];
//        Arrays.fill(depth, -1);
//
//        dfs(R, 0);
//
//        for(int i = 1; i <= N; i++){
//            System.out.println(depth[i]);
//        }
//    }
//
//    public static void dfs(int v, int d) {
//
//        visited[v] = true;
//        depth[v] = d;
//
//        for(int next = N; next > 0; next--) {
//            if(graph[v][next] == 1 && !visited[next]) {
//                dfs(next,d+1);
//            }
//        }
//
//    }
//}

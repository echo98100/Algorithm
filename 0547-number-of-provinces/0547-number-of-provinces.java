// 1. BFS
import java.util.*;

class Solution {

    static int N;
    static boolean[] visited;

    public int findCircleNum(int[][] isConnected) {
        
        N = isConnected.length;

        visited = new boolean[N];

        int count = 0;

        for(int i = 0; i < N; i++){
            if(!visited[i]) {
                bfs(isConnected, i);
                count++;
            }
        }

        return count;
    }
    
    public void bfs(int[][] isConnected, int start){

        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int now = q.poll();

            for(int next = 0; next < N; next++){
                if(!visited[next] && isConnected[now][next] == 1){
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
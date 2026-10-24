import java.util.*;

class Solution {
    
    static class State{
        int sheep, wolf;
        
        List<Integer> candidates;
        
        public State (int sheep, int wolf, List<Integer> candidates){
            this.sheep = sheep;
            this.wolf = wolf;
            this.candidates = candidates;
        }
    }
    
    static List<Integer>[] adjList;
    
    static int N;
    
    static int answer;
    
    public int solution(int[] info, int[][] edges) {
        answer = 0;
        
        N = info.length;
        
        adjList = new List[N];
        
        for(int i = 0; i < N; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges){
            adjList[edge[0]].add(edge[1]);
        }
        
        List<Integer> candidates = new ArrayList<>();
        candidates.add(0);
        
        dfs(info, new State(0,0,candidates));
        
        
        
        return answer;
    }
    
    public void dfs(int[] info, State state) {
        
        answer = Math.max(answer, state.sheep);
        
        for(int i = 0; i < state.candidates.size(); i++) {
            
            int node = state.candidates.get(i);
            
            int sheep = state.sheep + (info[node] == 0 ? 1 : 0);
            int wolf = state.wolf + (info[node] == 1 ? 1 : 0);
            
            if(sheep <= wolf) continue;
            
            List<Integer> next = new ArrayList<>(state.candidates);
            
            next.remove(i);
            
            for(int n : adjList[node]){
                next.add(n);
            }
            
            dfs(info, new State(sheep, wolf, next));
        }
        
        
        
    }
}
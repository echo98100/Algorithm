package boj_14567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //정점
		int M = Integer.parseInt(st.nextToken()); //간선
		int[] D = new int[N+1]; //진입 차수 배열
		List<Integer>[] graph = new ArrayList[N+1]; //인접리스트
		int[] answer = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}		
		
		// 인접리스트 작성 및 진입 차수 배열 계산
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[from].add(to);
			D[to]++; //간선 목적지가 된다는건 선행조건이 붙는거니 진입차수 증가
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			if(D[i] == 0) { //진입 차수가 0인 정점 큐에 담음
				q.add(i);
			}
		}

		int size = 1;
		
		while(!q.isEmpty()) {
			int qsize = q.size();
			for(int s = 0; s < qsize; s++) {
				int current = q.poll();
				answer[current] = size;
				for(int next : graph[current]) {
					D[next]--;
					if(D[next] == 0) {
						q.add(next);
					}
				}
			}
			size++;
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.print(answer[i]+" ");
		}
		
	}
}

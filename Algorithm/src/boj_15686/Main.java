package boj_15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static int N, M;
	static List<Pos> house, chicken;
	static int[][] map;
	
	static Pos[] comb;
	
	static class Pos {
		int r, c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int answer;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //map 사이즈
		M = Integer.parseInt(st.nextToken()); //최대 M 개 고름
		
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int now = Integer.parseInt(st.nextToken());
				map[i][j] = now;
				if(now == 1) {
					house.add(new Pos(i,j));
				} else if(now == 2) {
					chicken.add(new Pos(i,j));
				}
			}
		}
		
		comb = new Pos[M];
		answer = Integer.MAX_VALUE;
		
		combination(0,0);
		
		System.out.println(answer);
		
	}//main
	
	static int calculate(Pos[] comb) {
		
		int sum = 0;
		
		for(Pos h : house) {
			int min = Integer.MAX_VALUE;
			for(Pos c : comb) {
				min = Math.min(min, (Math.abs(h.r - c.r) + Math.abs(h.c - c.c)));	
			}
			sum += min;
		}
		
		
		return sum;
	}
	
	static void combination(int start, int depth) {
		
		if(depth == M) {
			answer = Math.min(answer, calculate(comb));
			return;
		}
		
		for(int i = 0; i < chicken.size(); i++) {
			comb[depth] = chicken.get(i);
			combination(i+1, depth+1);
		}
		
	}
	
}

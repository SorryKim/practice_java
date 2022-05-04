// 내리막 길 / baekjoon_1520.java
// https://www.acmicpc.net/problem/1520

import java.util.*;
import java.io.*;

public class Main {
	static int N,M;
	static int cnt = 0;
	static int[][] map;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1; // -1로 초기화
			}
		}
		
		System.out.print(DFS(0,0));;
		
	}
	
	// dp 없이 DFS만 실행할 경우 시간초과가 난다.
	public static int DFS(int x,int y) {
		
		// 도착지에 도착
		if(x == N - 1 && y == M - 1) {
			return 1;
		}
		
		// -1이 아닌 경우 이미 방문한 경로
		if(dp[x][y] != -1) {
			return dp[x][y];
		}
		
		
		int nowH = map[x][y];
		dp[x][y] = 0; // 0인 곳을 기준으로 dp
		
		// 상
		if(y+1 < M && nowH > map[x][y+1]) {
			dp[x][y] += DFS(x, y+1);
		}
		
		// 하
		if(y-1 >= 0 && nowH > map[x][y-1]) {
			dp[x][y] += DFS(x, y-1);
		}
		
		// 좌
		if(x - 1 >= 0  && nowH > map[x-1][y]) {
			dp[x][y] += DFS(x-1, y);
		}
		
		// 우
		if(x + 1 < N && nowH > map[x+1][y] ) {
			dp[x][y] += DFS(x + 1, y);
		}
		
		return dp[x][y];
			
	}
}

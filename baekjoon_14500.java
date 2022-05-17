// 테트로미노/ baekjoon_14500.java
// https://www.acmicpc.net/problem/14500
import java.util.*;
import java.io.*;


public class Main {
	static int[][] board;
	static boolean[][] check;
	static int result, N, M;
	static int[] moveX = {1,-1,0,0};
	static int[] moveY = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = 0;
		board = new int[N][M];
		check = new boolean[N][M];
		
		for(int i = 0;i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int n  = Integer.parseInt(st.nextToken());
				board[i][j] = n;
				check[i][j] = false;
			}
		}
		
		// ㅜ모양은 DFS로 확인 불가
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				check[i][j] = true;
				DFS(i, j, 0, 0);
				clearCheck();
			}
		}
		
		// ㅜ모양확인
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				calc(i,j);
			}
		}
		
		System.out.print(result);
		bw.close();
		br.close();
		
	}
	
	static void DFS(int x, int y, int cnt, int value) {
		cnt++;
		value += board[x][y];
		if(cnt == 4) {
			result = Math.max(result, value);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nowX = x + moveX[i];
			int nowY = y + moveY[i];
			if(nowX >= 0 && nowY >= 0 && nowX < N && nowY < M) {
				if(check[nowX][nowY] == false) {
					check[nowX][nowY] = true;
					DFS(nowX, nowY, cnt, value);
					check[nowX][nowY] = false;
				}
			}
		}
		
	}
	
	static void clearCheck() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				check[i][j] = false;
			}
		}
	}
	
	static void calc(int x,int y) {
		int value = board[x][y];
		int v1 = 0, v2 = 0, v3 = 0, v4 = 0;
		
		// 상
		if(y + 1< M) 
			v1 = board[x][y+1];
		// 하
		if(y - 1 >= 0) 
			v2 = board[x][y-1];
		// 좌
		if(x - 1 >= 0)
			v3 = board[x-1][y];
		// 우
		if(x + 1 < N)
			v4 = board[x+1][y];
		
		int min = Math.min(Math.min(v1, v2), Math.min(v3, v4));
		
		int sum = v1 + v2 + v3 + v4 - min;
		
		value += sum;
		
		result = Math.max(result, value);
		
	}
	
	
}

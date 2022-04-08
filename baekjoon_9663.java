// N-Queen / baekjoon_9663.java
// https://www.acmicpc.net/problem/9663

import java.io.*;
import java.util.*;
import java.lang.String;


public class Main {
	
	public static int N;
	public static int result = 0;
	public static int[] board;
	
	// n행에 퀸을 놓을 수 있는지 없는지 알려주는 메소드
	public static boolean check(int[] board, int n) {
		for(int i = 1; i < n; i++) {
			// 전 행들 중에서 열이 겹치는 경우
			if(board[i] == board[n])
				return false;
			// 가로 - 가로의 절댓값과 세로 - 세로의 절댓값이 같으면 같은 대각선상에 위치하게 된다.
			if(Math.abs(n-i) == Math.abs(board[i] - board[n]))
				return false;
		}
		return true;
	}
	
	public static void DFS(int[] board, int n) {
		// 마지막 N행에 다다르면 재귀를 종료, 경우의 수 1증가
		if(n == N) {
			result++;
			return;
		}
		else {
			for(int i = 1; i <= N; i++) {
				board[n+1] = i; // n+1행의 퀸에 위치 찾기
				// 퀸에 위치가 맞을 경우 다음행으로 이동
				if(check(board, n+1)) {
					DFS(board,n+1);
				}
				// 아닌 경우 다음열로 이동하면서 퀸의 위치 찾기
				else
					continue;
			}
		}
	}
	
	// 보드초기화
	public static void clear(int[] board) {
		for(int i = 1; i <= N; i++) {
			board[i] = 0;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		board = new int[N+1];
		for(int i = 1; i <= N; i++) {
			clear(board);
			board[1]= i; // 1행 i열에 퀸이 있는 경우, 퀸은 1행에 1개밖에 존재할 수 없다.
			DFS(board,1); // 1행부터 DFS시작
		}
		
		bw.write(Integer.toString(result));
		br.close();
		bw.close();
		
	}
}

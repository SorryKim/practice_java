// 쿼드트리 / baekjoon_1992.java
// https://www.acmicpc.net/problem/1992

import java.io.*;
import java.util.*;
import java.lang.String;

public class Main {
	
	public static int N;
	public static int[][] graph;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		graph = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				graph[i][j] = s.charAt(j) - '0';
			}
		}
		
		Traversal(0,0,N);

	}
	
	// 구역을 확인하는 메소드
	public static boolean Check(int x, int y, int n) {
		int first = graph[x][y];
		for(int i = x; i < x + n; i++) {
			for(int j = y; j < y+n; j++) {
				if(first != graph[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	// 순회 메소드
	public static void Traversal(int x, int y, int n) {
		if(Check(x,y,n)) {
			if(graph[x][y] == 1) {
				System.out.print(1);
			}
			else
				System.out.print(0);
			return;
		}
		else {
			System.out.print("(");
			Traversal(x,y,n/2);
			Traversal(x ,y + n/2,n/2);
			Traversal(x + n/2,y,n/2);
			Traversal(x+n/2,y+n/2,n/2);
			System.out.print(")");
		}
		
	}
	
}

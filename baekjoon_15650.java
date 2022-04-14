// N과 M (2) / baekjoon_15650.java
// https://www.acmicpc.net/problem/15650

import java.io.*;
import java.util.*;

public class Main {
	
	public static int N,M;
	public static int[] arr;
	
	public static void DFS(int n, int depth) {
		if(depth == M) {
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] != 0) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.print("\n");
			return;
			
		}
		else {
			for(int i = n; i <= N; i++) {
				arr[depth] = i;
				DFS(i + 1, depth + 1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];

		DFS(1,0);
		
		bw.close();
		br.close();
	}

}

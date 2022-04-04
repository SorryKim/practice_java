// 구간 합 구하기 5 / baekjoon_11660.java
// https://www.acmicpc.net/problem/11660

import java.io.*;
import java.util.*;
import java.lang.String;


public class Main {
	public static int N,M;
	public static int[][] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1];
		
		// 0번은 0으로 초기화
		for(int i = 0; i <= N; i++) {
			arr[0][i] = 0;
		}
		
		// 입력받은 배열을 누적합으로 저장
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = arr[i][j-1] + num;
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1,y1,x2,y2;
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			int sum = calc(x1,y1,x2,y2);
			bw.write(Integer.toString(sum) + "\n");
		}
		br.close();
		bw.close();
	}
	
	// 한줄의 결과를 끝과 맨처음 전의 원소를 빼서 시간복잡도를 O(n)으로 구현
	public static int calc(int x1, int y1, int x2, int y2) {
		int sum = 0;
		for(int i = x1; i <= x2; i++) {
			sum += arr[i][y2] - arr[i][y1-1];
		}
		return sum;
	}
		
	
}

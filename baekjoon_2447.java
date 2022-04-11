// 별 찍기 - 10 / baekjoon_2447.java
// https://www.acmicpc.net/problem/2447

import java.io.*;
import java.util.*;
import java.lang.String;


public class Main {
	
	public static int N;
	public static char[][] arr;
	
	public static void draw(int x, int y, int size) {
		
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(i >= x + size/3 && i < x + size*2/3 && j >= y + size/3 && j < y + size*2/3) {
					arr[i][j] = ' ';
				}
				else {
					arr[i][j] = '*';
				}
			}
		}
		// 크기가 3인경우 재귀 종료
		if(size == 3)
			return;
		// 중앙부분은 재귀하지 않아도 된다
		draw(x,y,size/3);
		draw(x + size/3,y,size/3);
		draw(x + size*2/3, y, size/3);
		draw(x,y + size/3,size/3);
		draw(x + size*2/3 , y + size/3,size/3);
		draw(x,y + size*2/3,size/3);
		draw(x + size/3, y + size*2/3, size/3);
		draw(x + size*2/3, y + size*2/3, size/3);
		}
	

		
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new char[N + 1][N + 1];
		
		draw(1,1,N);
		
		// 결과 출력
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <=N; j++) {
				bw.write(arr[i][j]);
			}
			bw.write("\n");
		}
		
		br.close();
		bw.close();
		
	}
}

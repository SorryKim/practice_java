// 섬의 개수 / baekjoon_4963.java
// https://www.acmicpc.net/problem/4963
import java.util.*;
import java.io.*;

public class Main {
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			// 종료 시점
			if(w == 0 && h == 0)
				break;
			int[][] map = new int[w][h];
			
			// 그래프 입력받기
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					int num = Integer.parseInt(st.nextToken());
					map[j][i] = num;
				}
			}
			
			// 체크배열
			boolean[][] check = new boolean[w][h];
			for(int i = 0; i < w; i++) {
				for(int j = 0; j < h; j++)
					check[i][j] = false;
			}
			
			// 실행
			for(int i = 0; i < w; i++) {
				for(int j = 0; j < h; j++) {
					if(map[i][j] == 1 && check[i][j] == false) {
						cnt++;
						DFS(i,j,w,h,map,check);
					}
				}
			}
			
			// 결과
			System.out.println(cnt);
		}
	}
	
	public static void DFS(int x, int y, int w, int h, int[][] map, boolean[][] check) {
		check[x][y] = true;
		// x+1
		if(x+1 < w && map[x+1][y] == 1 && check[x+1][y] == false) {
			DFS(x+1,y,w,h,map,check);
		}
		// x-1
		if(x - 1 >= 0 && map[x-1][y] == 1 && check[x-1][y] == false) {
			DFS(x-1,y,w,h,map,check);
		}
		
		// y+1
		if(y+1 < h && map[x][y+1] == 1 && check[x][y+1] == false) {
			DFS(x,y+1,w,h,map,check);
		}
		// y-1
		if(y-1 >= 0 && map[x][y-1] == 1 && check[x][y-1] == false) {
			DFS(x,y-1,w,h,map,check);
		}
		
		// x + 1, y + 1
		if(x + 1 < w && y + 1 < h && map[x+1][y+1] == 1 && check[x+1][y+1] == false) {
			DFS(x+1,y+1,w,h,map,check);
		}
		
		// x + 1, y - 1
		if(x + 1 < w && y - 1 >= 0 && map[x+1][y-1] == 1 && check[x+1][y-1] == false) {
			DFS(x+1,y-1,w,h,map,check);
		}
		
		// x - 1, y + 1
		if(x - 1 >= 0 && y + 1 < h && map[x-1][y+1] == 1 && check[x-1][y+1] == false) {
			DFS(x-1,y+1,w,h,map,check);
		}
		
		// x - 1, y - 1
		if(x - 1 >= 0 && y - 1 >= 0 && map[x-1][y-1] == 1 && check[x-1][y-1] == false) {
			DFS(x-1,y-1,w,h,map,check);
		}
		
	}

}

// 돌 게임/ baekjoon_9655.java
// https://www.acmicpc.net/problem/9655
import java.util.*;
import java.io.*;

public class Main {

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n  = Integer.parseInt(br.readLine());
		
		// 주어진 돌이 홀수일 경우 상근이가 무조건 마지막 돌을 가져감을 알 수 있다.
		if(n%2 == 1)
			bw.write("SK");
		// 주어진 돌이 짝수인 경우 창수가 마지막 돌을 가져갈 수 있음을 알 수 있다.
		else
			bw.write("CY");
		
		bw.close();
		br.close();
		
	}
	
	
}

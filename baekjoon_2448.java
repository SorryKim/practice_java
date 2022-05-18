// 별 찍기 - 11 / baekjoon_2448.java
// https://www.acmicpc.net/problem/2448
import java.util.*;
import java.io.*;

public class Main {
	
	static String[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
	
		arr = new String[N];
		arr[0] = "  *  ";
		arr[1] = " * * ";
		arr[2] = "*****";
		
		for(int i = 1; 3 * (int)Math.pow(2,i) <= N; i++) {
			func(i);
		}
		
		for(int i = 0; i < N; i++) {
			bw.write(arr[i] + "\n");
		}
		
		bw.close();
		br.close();
		
	}
	
	public static void func(int n) {
		
		int bottom = 3 * (int)Math.pow(2, n);
		int mid = bottom / 2;
		
		// 새로운 문자열은 앞의 문자열 + 공백 + 문자열이다.
		for(int i = mid; i < bottom; i++) {
			arr[i] = arr[i - mid] + " " + arr[i - mid];
		}
		
		// 추가할 공백의 길이 구하기
		String str =  "";
		for(int i = 0; i < mid; i++) {
			str += " ";
		}
		
		// 0 ~ 중간부분의 앞뒤로 공백 추가
		for(int i = 0; i < mid; i++)
			arr[i] = str + arr[i] + str;
	}
	
}

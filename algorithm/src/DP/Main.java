package DP;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int mem[] = new int[11];
		mem[0] = 1;
		mem[1] = 1;
		mem[2] = 2;
		while(T-->0) {
			int N = scan.nextInt();
			for(int i=3; i<=N ; i++) {
				if(mem[i] == 0) mem[i] = mem[i-1] + mem[i-2] + mem[i-3];
			}
			System.out.println(mem[N]);
		}
	}
	
	// 1,2,3 더하기
	// mem[N] = 정수 N을 1,2,3의 합으로 나타내는 방법의 수
	// ex> mem[4] = (1+1+1)+1 / (1+2)+1 / (1+1)+2 / (1)+3 / (2+1)+1 / (2)+2 / (3)+1 
	// 						=> mem[1] + mem[2] + mem[3]
	// 
}

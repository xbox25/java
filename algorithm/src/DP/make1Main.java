package DP;

import java.util.Scanner;

public class make1Main {

	static int mem[] = new int[1000001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		cal(N);
		System.out.println(mem[N]);
	}

	static void cal(int num) {
		for(int i = 1; i<=num; i++) {
			mem[i] = -1;
		}
		mem[1] = 0;
		mem[2] = 1;
		mem[3] = 1;
		for(int i = 1; i<=num; i++) {
			
			if( i+1 <= num && mem[i+1] == -1) {
				if(i+1 <= num) mem[i+1] = mem[i] + 1;
			}else {
				if(i+1 <= num) mem[i+1] = Math.min(mem[i+1], mem[i] + 1);
			}
			
			if( i*2 <= num && mem[i*2] == -1) {
				if(i*2 <= num) mem[i*2] = mem[i] + 1;
			}else {
				if(i*2 <= num) mem[i*2] = Math.min(mem[i*2], mem[i] + 1);
			}
			
			if( i*3 <= num && mem[i*3] == -1 ) {
				if(i*3 <= num) mem[i*3] = mem[i] + 1;
			}else {
				if(i*3 <= num) mem[i*3] = Math.min(mem[i*3], mem[i] + 1);
			}
		}
		return;
	}
}

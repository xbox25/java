package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class boj_2644 {

	static int N, M;
	static boolean[][][][] map;
	static ArrayList<Integer> array = new ArrayList<Integer>();

	public static void main(String[] args) {
		int[] answer;
		Scanner input = new Scanner(System.in);
		int l1 = input.nextInt();
		int l2 = input.nextInt();
		N = l1;
		M = l2;
		// map 초기화
		map = new boolean[l1 + 1][l2 + 1][l1 + 1][l2 + 1];
		for (int i = 0; i <= l1; i++)
			for (int j = 0; j <= l2; j++)
				for (int n = 0; n <= l1; n++)
					for (int m = 0; m <= l2; m++) {
						if (i == n && j == m) {
							map[i][j][n][m] = true;
						} else {
							map[i][j][n][m] = false;
						}
					}

		// 탐색
		dfs(0, 0, N, 0, N);
		dfs(0, 0, 0, M, M);

		int size = 0;
		answer = new int[array.size()];
		for (int num : array) {
			answer[size++] = num;
		}
		Arrays.sort(answer);
		for (int i = 0; i < size; i++)
			System.out.println(answer[i]);

	}

	static void dfs(int x, int y, int nx, int ny, int diff) {
		map[x][y][nx][ny] = true;
		
		if (!array.contains(diff)) {
			array.add(diff);
		}

		// 1번 가득채우기
		if (!map[nx][ny][N][ny]) {
			dfs(nx, ny, N, ny, N - nx);
		}

		// 1번 비우기
		if (!map[nx][ny][0][ny]) {
			dfs(nx, ny, 0, ny, nx);
		}
		// 2번 가득채우기
		if (!map[nx][ny][nx][M]) {
			dfs(nx, ny, nx, M, M - ny);
		}

		// 2번 비우기
		if (!map[nx][ny][nx][0]) {
			dfs(nx, ny, nx, 0, ny);
		}

		// 1번 -> 2번
		if (nx + ny > M) {
			if (!map[nx][ny][nx - (M - ny)][M]) {
				dfs(nx, ny, nx - (M - ny), M, M - ny);
			}
		} else {
			if (!map[nx][ny][0][nx + ny]) {
				dfs(nx, ny, 0, nx + ny, nx);
			}
		}

		// 2번 -> 1번
		if (nx + ny > N) {
			if (!map[nx][ny][N][ny - (N-nx)]) {
				dfs(nx, ny, N, ny - (N-nx), N-nx);
			}
		} else {
			if (!map[nx][ny][nx+ny][0]) {
				dfs(nx, ny, nx + ny, 0, ny);
			}
		}
	}

}

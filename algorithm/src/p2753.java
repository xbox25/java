import java.util.LinkedList;
import java.util.Queue;

public class p2753 {
	
	int calc(int[][] map)
	{
		
		
		return ret;
	}
	
	// 
	static boolean check(int map[][]) {

		for(int i = 0 ; i<300; i++){
			for(int j=0; j<300; j++) {
				if(map[i][j] != 0) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	static void melt(int[][] map) {
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		for(int x=0; x<300; x++) {
			for(int y=0; y<300; y++) {
				int cnt = 0;
				for(int dir = 0; dir<4; dir++) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					if(map[nx][ny] == 0) {
						cnt++;
					}
				}
				map[x][y] -= cnt;
				if(map[x][y] < 0) map[x][y] = 0;
			}
		}
	}
	
	static int count(int[][] map) {
		int ret = 1;
		int cnt = 0;
		int tmp = 0;
		for(int x = 0; x < 300; x++) {
			for(int y = 0 ;y < 300; y++) {
				if(map[x][y] != 0) cnt++;
			}
		}
		
		boolean[][] visit = new boolean[300][300];
		
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		Queue q = new LinkedList();
		int sx = 0, sy = 0;
		for(int x = 0; x<300; x++) {
			for(int y= 0 ; y<300; y++) {
				if(map[x][y] != 0)
				{
					sx = x;
					sy = y;
					break;
				}
			}
		}
		
		
		while(!q.isEmpty()) {
			if(visit[sx][sy] == false) {
				visit[sx][sy]  = true;
				tmp++;
			}
			
			for(int dir = 0; dir< 4; dir++) {
				int nx = sx + dx[dir];
				int ny = sy + dy[dir];
			}
		}
		
		return ret;
	}
}

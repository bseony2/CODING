import java.io.*;
import java.util.*;
import java.lang.Comparable;

public class 포탑부수기 {
	static int N, M, K, turn =0;
	static Tower[][] towerMap;
	static List<Tower> towerList;
	static int[][] backR, backC, distance;
	static boolean[][] isVisited;
	static int[] dr = new int[] {0, 1, 0, -1, -1, 1, 1, -1};
	static int[] dc = new int[] {1, 0, -1, 0, 1, 1, -1, -1};
	public static void main(String[] args) throws IOException {
		init();
		
		simulate();
		
		System.out.println(towerList.get(towerList.size()-1).power);
	}
	
	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		backR = new int[N][M];
		backC = new int[N][M];
		distance = new int[N][M];
		isVisited = new boolean[N][M];
		
		towerMap = new Tower[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				int value = Integer.parseInt(st.nextToken());
				if(value > 0) {
					towerMap[i][j] = new Tower(i, j, value);
				}
			}
		}
	}

	static void simulate() {
		while(++turn<=K) {
			gather();
			
			if(towerList.size() == 1) {
				break;
			}
			
			Tower attacker = towerList.get(0);
			Tower defender = towerList.get(towerList.size()-1);
			attacker.time = turn;
			attacker.healAble = false;
			defender.healAble = false;
			
			attacker.power += M+N;
			
			setLaserRoute(attacker.r, attacker.c, defender);
			if(isVisited[defender.r][defender.c]) {
				laserAttack(attacker, defender);
			}
			else if(!isVisited[defender.r][defender.c]) {
				bombAttack(attacker, defender);
			}
			
			destroyTower();
			
			heal();
		}
		gather();
	}
	
	static void gather() {
		towerList = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(towerMap[i][j] instanceof Tower) {
					towerList.add(towerMap[i][j]);
				}
			}
		}
		Collections.sort(towerList);
	}
	
	static void setLaserRoute(int r, int c, Tower defender) {
		
		for(int i=0; i<N; i++) {
			Arrays.fill(backR[i], -1);
			Arrays.fill(backC[i], -1);
			Arrays.fill(distance[i], -1);
			Arrays.fill(isVisited[i], false);
		}
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {r, c});
		distance[r][c] = 0;
		isVisited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int[] point = queue.poll();
			int cr = point[0];
			int cc = point[1];
			
			for(int i=0; i<4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				
				if(nr >= N) nr = 0;
				if(nc >= M) nc = 0;
				
				if(nr < 0) nr = N-1;
				if(nc < 0) nc = M-1;
				
				if(towerMap[nr][nc] == null || isVisited[nr][nc]) continue;
				
				backR[nr][nc] = cr;
				backC[nr][nc] = cc;
				distance[nr][nc] = distance[cr][cc] + 1;
				isVisited[nr][nc] = true;
				queue.add(new int[] {nr, nc});
				
				if(nr == defender.r && nc == defender.c) {
					queue.clear();
					break;
				}
			}
		}
	}
	
	static void laserAttack(Tower attacker, Tower defender) {
		defender.power -= attacker.power;
		int r = backR[defender.r][defender.c];
		int c = backC[defender.r][defender.c];
		
		while(r != attacker.r || c != attacker.c) {
			if(towerMap[r][c] != null) {
				towerMap[r][c].power -= (attacker.power / 2);
				towerMap[r][c].healAble = false;
			}
			int nr = backR[r][c];
			int nc = backC[r][c];
			
			r = nr;
			c = nc;
		}
		
	}
	
	static void bombAttack(Tower attacker, Tower defender) {
		defender.power -= attacker.power;
		for(int i=0; i<8; i++) {
			int nr = defender.r + dr[i];
			int nc = defender.c + dc[i];
			
			if(nr >= N) nr = 0;
			if(nc >= M) nc = 0;
			
			if(nr < 0) nr = N-1;
			if(nc < 0) nc = M-1;
			
			if(towerMap[nr][nc] != null && towerMap[nr][nc] != attacker) {
				towerMap[nr][nc].power -= (attacker.power / 2);
				towerMap[nr][nc].healAble = false;
			}
		}
	}
	
	static void destroyTower() {
		for(Tower tower : towerList) {
			if(tower.power <= 0) {
				towerMap[tower.r][tower.c] = null;
			}
		}
	}
	
	static void heal() {
		for(Tower tower : towerList) {
			if(tower.healAble) {
				tower.power += 1;
			}
			tower.healAble = true;
		}
	}
	
	static class Tower implements Comparable<Tower>{
		int power, time, r, c;
		boolean healAble;
		public Tower(int r, int c, int power) {
			this.r = r;
			this.c = c;
			this.power = power;
			this.time = 0;
			this.healAble = true;
		}
		
		public int compareTo(Tower tower) {
			if(this.power != tower.power) return this.power - tower.power;
			if(this.time != tower.time) return tower.time - this.time;
			if(this.r + this.c != tower.r + tower.c) return tower.r + tower.c - (this.r + this.c);
			return tower.c - this.c;
		}
	}
}

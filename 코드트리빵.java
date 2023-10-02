import java.io.*;
import java.util.*;
public class 코드트리빵 {

	static int N, M;
	static int[][] map;
	static List<int[]> persons = new ArrayList<>();
	static List<int[]> stores = new ArrayList<>();
	static Queue<int[]> closedStore = new LinkedList<>();
	static int[][] distance;
	static boolean[][] isVisited;
	static int[] dr = new int[]{-1, 0, 0, 1};
	static int[] dc = new int[]{0, -1, 1, 0};
	static int turn = 0;
	static boolean[] arrive;
	public static void main(String[] args) throws IOException {
		init();

		simulate();

		System.out.print(turn);
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		distance = new int[N][N];
		isVisited = new boolean[N][N];
		arrive = new boolean[M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;

			stores.add(new int[]{r, c});
		}
	}

	static void simulate() {
		while (true) {
			turn += 1;

			allMove();

			setNewPerson();

			if (isDone())
				break;
		}
	}

	static void allMove() {
		for (int i = 0; i < persons.size(); i++) {
			int[] person = persons.get(i);
			int[] store = stores.get(i);

			if (arrive[i])
				continue;

			setDistance(store[0], store[1]);
			int r = -1, c = -1;
			int dis = Integer.MAX_VALUE;
			for (int j = 0; j < 4; j++) {
				int nr = person[0] + dr[j];
				int nc = person[1] + dc[j];

				if (!isValidPoint(nr, nc) || !isVisited[nr][nc]
						|| distance[nr][nc] >= dis)
					continue;

				dis = distance[nr][nc];
				r = nr;
				c = nc;
			}

			person[0] = r;
			person[1] = c;

			if (person[0] == store[0] && person[1] == store[1]) {
				closedStore.add(store);
				arrive[i] = true;
			}

		}
		setBlock();
	}

	static void setNewPerson() {
		if (persons.size() >= stores.size())
			return;

		int personIndex = persons.size();
		int[] store = stores.get(personIndex);
		setDistance(store[0], store[1]);

		int r = -1, c = -1, dis = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && distance[i][j] < dis && isVisited[i][j]) {
					r = i;
					c = j;
					dis = distance[i][j];
				}
			}
		}

		persons.add(new int[]{r, c});
		map[r][c] = -1;
	}

	static void setBlock() {
		while (!closedStore.isEmpty()) {
			int[] store = closedStore.poll();
			map[store[0]][store[1]] = -1;
		}
	}

	static boolean isDone() {
		for (int i = 0; i < M; i++) {
			if (!arrive[i])
				return false;
		}
		return true;
	}

	static void setDistance(int r, int c) {
		for (int i = 0; i < N; i++) {
			Arrays.fill(distance[i], 0);
			Arrays.fill(isVisited[i], false);
		}

		Queue<int[]> queue = new LinkedList<>();
		isVisited[r][c] = true;
		queue.add(new int[]{r, c});

		while (!queue.isEmpty()) {
			int[] point = queue.poll();
			int cr = point[0];
			int cc = point[1];

			for (int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];

				if (!isValidPoint(nr, nc) || isVisited[nr][nc]
						|| map[nr][nc] == -1)
					continue;

				distance[nr][nc] = distance[cr][cc] + 1;
				isVisited[nr][nc] = true;
				queue.add(new int[]{nr, nc});
			}
		}
	}

	static boolean isValidPoint(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}
}


// import java.io.*;
// import java.util.*;

// public class 코드트리빵 {
// 	static int[][] map;
// 	static boolean[][] lock, isVisited;
// 	static int N, M;
// 	static int turn;
// 	static ArrayList<int[]> stores = new ArrayList<>();
// 	static ArrayList<Person> personList = new ArrayList<>();
// 	static int[][] distance;
// 	static int[] dr = new int[] {-1, 0, 0, 1};
// 	static int[] dc = new int[] {0, -1, 1, 0};
// 	public static void main(String[] args) throws IOException {
// 		init();
		
// 		simulate();
		
// 		System.out.println(turn);
// 	}
	
// 	static void init() throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
// 		N = Integer.parseInt(st.nextToken());
// 		M = Integer.parseInt(st.nextToken());
		
// 		map = new int[N][N];
// 		lock = new boolean[N][N];
// 		isVisited = new boolean[N][N];
// 		distance = new int[N][N];
		
// 		for(int i=0; i<N; i++) {
// 			st = new StringTokenizer(br.readLine(), " ");
// 			for(int j=0; j<N; j++) {
// 				int value = Integer.parseInt(st.nextToken());
// 				map[i][j] = value;
// 			}
// 		}
		
// 		for(int i=0; i<M; i++) {
// 			st = new StringTokenizer(br.readLine(), " ");
// 			int r = Integer.parseInt(st.nextToken())-1;
// 			int c = Integer.parseInt(st.nextToken())-1;
			
// 			stores.add(new int[] {r, c});
// 		}
// 	}
	
// 	static void simulate() {
// 		turn = 1;
// 		while(true) {
			
// 			moveAllPerson();
			
// 			if(turn <=M) {
// 				setPersonOnCamp(turn-1);
// 			}
			
// 			if(allDone()) break;
// 			turn += 1;
// 		}
// 	}
	
// 	static void moveAllPerson() {
// 		for(Person person : personList) {
// 			if(person.isDone) continue;
			
// 			int[] store = stores.get(person.no);
// 			initDistance(store[0], store[1]);
			
// 			int minDis = Integer.MAX_VALUE;
// 			int r=0, c=0;
			
// 			for(int i=0; i<4; i++) {
// 				int nr = person.r + dr[i];
// 				int nc = person.c + dc[i];
				
// 				if(isValidPoint(nr, nc) && isVisited[nr][nc] && distance[nr][nc] < minDis) {
// 					minDis = distance[nr][nc];
// 					r = nr;
// 					c = nc;
// 				}
// 			}
			
// 			person.r = r;
// 			person.c = c;
			
// 			if(person.r == store[0] && person.c == store[1]) {
// 				person.isDone = true;
// 				lock[store[0]][store[1]] =  true;
// 			}
// 		}
// 	}
	
// 	static void setPersonOnCamp(int personNo) {
// 		int[] store = stores.get(personNo);
// 		initDistance(store[0], store[1]);
		
// 		int minDist = Integer.MAX_VALUE;
//         int r = -1, c = -1;
//         for(int i = 0; i < N; i++) {
//             for(int j = 0; j < N; j++) {
//                 if(isVisited[i][j] && map[i][j] == 1 && minDist > distance[i][j]) {
//                     minDist = distance[i][j];
//                     r = i; c = j;
//                 }
//             }
//         }
        
//         personList.add(new Person(personNo, r, c));
// 		lock[r][c] = true;
// 	}
	
// 	static void initDistance(int r, int c) {
// 		Queue<int[]> queue = new LinkedList<>();
// 		for(int i=0; i<N; i++) {
// 			Arrays.fill(distance[i], 0);
// 			Arrays.fill(isVisited[i], false);
// 		}
		
// 		queue.add(new int[] {r, c});
// 		distance[r][c] = 1;
// 		isVisited[r][c] = true;
		
// 		while(!queue.isEmpty()) {
// 			int[] point = queue.poll();
// 			int cr = point[0];
// 			int cc = point[1];
			
// 			for(int i=0; i<4; i++) {
// 				int nr = cr + dr[i];
// 				int nc = cc + dc[i];
				
// 				if(!isValidPoint(nr, nc) || lock[nr][nc] || isVisited[nr][nc]) continue;
				
// 				queue.add(new int[]{nr, nc});
// 				distance[nr][nc] = distance[cr][cc] + 1;
// 				isVisited[nr][nc] = true;
// 			}
// 		}	
// 	}
	
// 	static boolean allDone() {
		
// 		for(Person person : personList) {
// 			if(!person.isDone) return false;
// 		}
		
// 		return true;
// 	}
	
// 	static boolean isValidPoint(int r, int c) {
// 		return 0<=r && r<N && 0<=c && c<N;
// 	}
	
// 	static class Person {
// 		int no, r, c;
// 		boolean isDone = false;
// 		public Person(int no, int r, int c) {
// 			this.no = no;
// 			this.r = r;
// 			this.c = c;
// 		}
// 	}
// }

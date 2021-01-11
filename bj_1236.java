import java.util.Scanner;

public class bj_1236 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();	// 세로
		int M = scan.nextInt();	// 가로
		int row = 0;	// 행
		int col = 0;	// 열
		char[][] map = new char[N][M];
		for(int i=0; i<map.length; i++) {
			String str = scan.next();
			for(int j=0; j<map[i].length; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		// 행에 필요한 경비원 수
		for(int i=0; i<N; i++) {
			boolean flag = true;
			for(int j=0; j<M; j++) {
				if(map[i][j] == 'X') {
					flag = false;
					break;
				}
			}
			if(flag)
				row ++;
		}
		
		// 열에 필요한 경비원 수
		for(int i=0; i<M; i++) {
			boolean flag = true;
			for(int j=0; j<N; j++) {
				  if(map[j][i] == 'X') {
					  flag = false;
					  break;
				  }
			}
			if(flag)
				col ++;
		}
		
		// 행, 열 중 더 많은 경비원 추가
		System.out.println(Math.max(row, col));
		scan.close();
	}

}
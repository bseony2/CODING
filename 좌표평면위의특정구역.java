import java.io.*;
import java.util.*;
import java.lang.Math;

public class 좌표평면위의특정구역 {
	static int N;
	static final int MIN = 1;
	static final int MAX = 40000;
	// 4 방향에 대해 가장 끝에 있는 점을 제거할 경우 두번째로 끝에 있는 좌표가 기준이 될 수 있으므로 
	// 두번째로 끝부분에 있는 좌표에 대해서도 저장하고 있어야 함
	static int[][] points = new int[][] { 
		{ 0, Integer.MIN_VALUE, 0, Integer.MIN_VALUE } // 가장 위쪽 좌표
		, { 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE } // 가장 아래쪽 좌표
		, { Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0 } // 가장 왼쪽 좌표
		, { Integer.MIN_VALUE, 0, Integer.MIN_VALUE, 0 } // 가장 오른쪽 좌표
	};
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			// 입력된 좌표가 기존에 있던 가장 끝 부분 좌표(상하좌우 네 방향에 대해)보다 끝에 있을경우 변경
			setBigValue(x, y);
		}

		for (int[] point : points) {
			// 상 하 좌 우 네개의 좌표중 하나씩 제거를 하나씩 제거하면서 넓이 비교
			getAreaExceptOnePoint(point[0], point[1]);
		}

		System.out.print(ans);
	}

	static void setBigValue(int x, int y) {
		if (points[0][1] < y) {
			points[0][2] = points[0][0];
			points[0][3] = points[0][1];
			points[0][0] = x;
			points[0][1] = y;
		} else if (points[0][3] < y) {
			points[0][2] = x;
			points[0][3] = y;
		}

		if (points[1][1] > y) {
			points[1][2] = points[1][0];
			points[1][3] = points[1][1];
			points[1][0] = x;
			points[1][1] = y;
		} else if (points[1][3] > y) {
			points[1][2] = x;
			points[1][3] = y;
		}

		if (points[2][0] > x) {
			points[2][2] = points[2][0];
			points[2][3] = points[2][1];
			points[2][0] = x;
			points[2][1] = y;
		} else if (points[2][2] > x) {
			points[2][2] = x;
			points[2][3] = y;
		}

		if (points[3][0] < x) {
			points[3][2] = points[3][0];
			points[3][3] = points[3][1];
			points[3][0] = x;
			points[3][1] = y;
		} else if (points[3][2] < x) {
			points[3][2] = x;
			points[3][3] = y;
		}
	}

	static void getAreaExceptOnePoint(int x, int y) {
		int high = MIN;
		int low = MAX;
		int rightPoint = MIN;
		int leftPoint = MAX;

		for (int[] point : points) {
			if (x != point[0] || y != point[1]) {
				high = Math.max(high, point[1]);
				low = Math.min(low, point[1]);
				rightPoint = Math.max(rightPoint, point[0]);
				leftPoint = Math.min(leftPoint, point[0]);
			} else {
				high = Math.max(high, point[3]);
				low = Math.min(low, point[3]);
				rightPoint = Math.max(rightPoint, point[2]);
				leftPoint = Math.min(leftPoint, point[2]);
			}
		}

		int area = (high - low) * (rightPoint - leftPoint);
		ans = Math.min(ans, area);
	}
}

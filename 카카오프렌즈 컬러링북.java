import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int[][] pictures;
    int[] dy = {-1, 1, 0, 0}; //위, 아래, 오른쪽, 왼쪽
    int[] dx = {0, 0, 1, -1};
    boolean[][] visited;
    int maxX; int maxY;
    Queue<Integer> queue;

    public int bfs(int i, int j, int key){
        queue.add(i); queue.add(j);
        int value = 0;
        visited[i][j] = true;
        while(!queue.isEmpty()){
            value ++;
            int y = queue.poll();
            int x = queue.poll();
            for(int num=0; num<4; num++){
                int ny = y + dy[num];
                int nx = x + dx[num];
                if((0 <= ny && ny <maxY) && (0 <= nx && nx < maxX) && (pictures[ny][nx] == key) && (!visited[ny][nx])){
                    queue.add(ny); queue.add(nx);
                    visited[ny][nx] = true;
                }
            }
        }
        return value;

        
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        pictures = picture;
        maxY = m; maxX = n;
        visited = new boolean[m][n];
        queue = new LinkedList<>();
        for(int i=0; i<picture.length; i++){
            for(int j=0; j<picture[i].length; j++) 
                visited[i][j] = false;
        }

        for(int i=0; i<picture.length; i++){
            for(int j=0; j<picture[i].length; j++){
                if(picture[i][j] == 0 ) continue;
                if(!visited[i][j]){
                    numberOfArea++;
                    int result = bfs(i, j, picture[i][j]);
                    maxSizeOfOneArea = (maxSizeOfOneArea < result) ? result : maxSizeOfOneArea;
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}

class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] picture = {{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};
        System.out.println(solution.solution(6, 4, picture));
    }
}
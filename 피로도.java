class Solution_피로도 {

    int answer = Integer.MIN_VALUE;
    public boolean[] isVisited;

    public int solution(int k, int[][] dungeons) {

        isVisited = new boolean[dungeons.length];

        dfs(0, k, dungeons);

        return answer;
    }

    public void dfs(int depth, int k, int[][]dungeons)
    {
        for(int i=0; i<dungeons.length; i++)
        {
            if(!isVisited[i] && k >= dungeons[i][0])
            {
                isVisited[i] = true;
                dfs(depth + 1, k-dungeons[i][1], dungeons);
                isVisited[i] = false;
            }
        }

        answer = answer > depth ? answer : depth;
    }
}

/**
 * 피로도
 */
public class 피로도 {

    public static void main(String[] args) {
        int[][] dungeons = {{80,20}, {50, 40}, {30, 10}};

        Solution_피로도 s = new Solution_피로도();
        System.out.println(s.solution(80, dungeons));
        
    }
}


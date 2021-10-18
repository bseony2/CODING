import java.util.LinkedList;
import java.util.List;

class Solution_배열_자르기 {
    public List<Long> solution(int n, long left, long right) {
        List<Long> answer = new LinkedList<>();
        for(long i = left; i <= right; i++)
        {
            answer.add(Math.max(i/n, i%n) + 1);
        }
        return answer;
    }
}
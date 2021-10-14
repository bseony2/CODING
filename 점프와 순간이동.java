
class JumpAndTeleport {
    public int solution(int n) {
        int answer = 0;
        
        while(n != 0)
        {
            if(n%2 == 0) 
                n /= 2;
            else
            {
                n--;
                answer ++;
            }
        }

        return answer;
    }
}

class PrintJumpAndTeleport{
    public static void main(String[] args) {
        JumpAndTeleport solution = new JumpAndTeleport();
        System.out.println(solution.solution(5));
    }
}
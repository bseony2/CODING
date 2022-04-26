class Solution {
    public String solution(int n) {
        String answer = "";

        while(n > 0)
        {
            switch(n % 3)
            {
                case 0 : answer = "4" + answer;
                            break;
                case 1 : answer = "1" + answer;
                            break;
                case 2 : answer = "2" + answer;
                            break;
            }
            n = n % 3 < 1 ? (n / 3) - 1 : (int)(n / 3);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5));
    }
}
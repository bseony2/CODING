class Solution {
    public int solution(int n) {
        int answer = 1;
        int pre = 1;
        int post = 1;
        
        for(int i= 3; i<n + 1; i++) {
            answer = (pre + post) % 1234567;
            pre = post % 1234567;
            post = answer % 1234567;
        }
        
        return n == 0 ? 0 : answer;
    }
}
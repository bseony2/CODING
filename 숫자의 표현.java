import java.lang.Math;

class Solution {
    public int solution(int n) {
        if(n == 1)
			return 1;
        int answer = 0;
        int left = 0; 
        int right = 0;
        int sum = 0;
        int half = (int)(Math.round((double)n/2)) + 1;
        int[] array = new int[n + 1];
        for(int i=0; i<half; i++) {
            array[i] = i;
        }
        
        while(right < half - 1 || sum > n) {
            if(sum <= n ) {
                sum += array[++right];
            }  else if(sum > n){
                sum -= array[left++];
            }
            
            if(sum == n) {
                answer++;
            }
        }
        return answer + 1; //자기자신 포함
    }
}

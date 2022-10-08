class Solution {
    boolean solution(String s) {

        int count = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(')
                count++;
            else
                count--;
            
            if( count < 0)
                break;
        }
        
        return count == 0 ? true : false;
    }
}

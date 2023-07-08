class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int ini = section[0];
        
        for(int i=1; i<section.length; i++) {
            if(section[i] - ini + 1 > m) {
                answer++;
                ini = section[i];
            }
        }
        answer++;
        
        return answer;
    }
}
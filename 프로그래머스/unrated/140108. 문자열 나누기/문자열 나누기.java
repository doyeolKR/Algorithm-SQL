class Solution {
    public int solution(String s) {
        int originCnt = 0;
        int otherCnt = 0;
        int answer = 0;
        
        char origin = 'a';
        
        for(int i = 0; i < s.length(); i++) {
            if(originCnt == 0 && otherCnt == 0) {
                origin = s.charAt(i);
            }
            
            char mozi = s.charAt(i);
            
            if(origin == mozi) originCnt++;
            else otherCnt++;
            
            if(originCnt == otherCnt) {
                answer++;
                originCnt = 0;
                otherCnt = 0;
                continue;
            }
            if(i == s.length() - 1) answer++;
        }
        return answer;
    }
}
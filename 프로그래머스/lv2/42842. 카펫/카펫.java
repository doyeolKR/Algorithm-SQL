class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int yRow = 0;
        int yCol = 0;
        
        for(int row = 1; row<5000; row++) {
            for(int col=1; col<5000; col++) {
                if(row * col == yellow && (row*2)+((col*2)+4)==brown) {
                    yRow = row;
                    yCol = col;
                    break;
                }
            }
        }
        
        answer[0] = yRow+2;
        answer[1] = yCol+2;
        
        return answer;
    }
}
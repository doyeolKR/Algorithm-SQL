import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] supo1 = {1,2,3,4,5}; //5
        int[] supo2 = {2,1,2,3,2,4,2,5}; //8
        int[] supo3 = {3,3,1,1,2,2,4,4,5,5}; // 10
        
        int supo1_cnt = 0;
        int supo2_cnt = 0;
        int supo3_cnt = 0;
        
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == supo1[i%5]) supo1_cnt++;
            if(answers[i] == supo2[i%8]) supo2_cnt++;
            if(answers[i] == supo3[i%10]) supo3_cnt++;
        }
        
        int best = Math.max(supo1_cnt, Math.max(supo2_cnt,supo3_cnt));
        
        int size = 0;
        
        if(supo1_cnt == best) size++;
        if(supo2_cnt == best) size++;
        if(supo3_cnt == best) size++;
        
        int[] answer = new int[size];
        
        int index = 0;
        
        if(supo1_cnt == best) {
            answer[index] = 1;
            index++;
        }
        if(supo2_cnt == best) {
            answer[index] = 2;
            index++;
        }
        if(supo3_cnt == best) {
            answer[index] = 3;
            index++;
        }
                
        return answer;
    }
}
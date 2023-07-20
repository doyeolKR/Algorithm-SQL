import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 정답 : 전체(n) - 체육복 없는 학생 수(lost - 체육복 빌린 학생 수)
        
        List<Integer> lostNumbers 
            = Arrays.stream(lost).boxed().collect(Collectors.toList());
        
        List<Integer> reserveNumbers 
            = Arrays.stream(reserve).boxed().collect(Collectors.toList());
        
        // 체육복 여분이 있지만 정작 본인도 도둑맞아서 빌려줄 수 없는 학생 제외
        for(int i = 0; i < lost.length; i++) {
            if(reserveNumbers.contains(lost[i])) {
                lostNumbers.remove(Integer.valueOf(lost[i]));
                reserveNumbers.remove(Integer.valueOf(lost[i]));
            }
        }
        
        Collections.sort(lostNumbers);
        Collections.sort(reserveNumbers);
        
        int success = 0;
        
        for(int i = 0; i < lostNumbers.size(); i++) {
            int num = lostNumbers.get(i);
            
            if(reserveNumbers.contains(num - 1)) {
                reserveNumbers.remove(Integer.valueOf(num - 1));
                success++;
            }
            else if(reserveNumbers.contains(num + 1)) {
                reserveNumbers.remove(Integer.valueOf(num + 1));
                success++;
            }
        }
        return n - (lostNumbers.size() - success);
    }
}
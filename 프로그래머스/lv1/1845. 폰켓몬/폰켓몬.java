import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }
        
        int cnt = set.size();
        int N = nums.length/2;
        
        int answer = cnt > N ? N : cnt;
        
        return answer;
    }
}
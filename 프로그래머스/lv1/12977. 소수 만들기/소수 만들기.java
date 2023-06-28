import java.util.*;

class Solution {
    public static int answer = 0;
    
    public boolean isPrime(int n) {
        for(int i=2; i<=(int)Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
    
    public void comb(int[] nums, boolean[] visited, int start, int depth) {
        if(depth == 3) {
            int sum = 0;
            for(int i=0; i<nums.length; i++) {
                if(visited[i]) sum += nums[i];
            }
            if(isPrime(sum)) answer++;
            return;
        }
        
        for(int i=start; i<nums.length; i++) {
            visited[i] = true;
            comb(nums, visited, i + 1, depth + 1);
            visited[i] = false;
        }
    }
    
    public int solution(int[] nums) {
        
        boolean[] visited = new boolean[nums.length];
        comb(nums, visited, 0, 0);
        
        return answer;
    }
}
import java.util.*;

class Solution {  
    public boolean isPrime(int n) {
        for(int i=2; i<=(int)Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    } 
    
    public int solution(int[] nums) {
        int answer = 0;
        
        for(int x = 0; x < nums.length - 2; x++) {
            for(int y = x + 1; y<nums.length - 1; y++) {
                for(int z = y + 1; z<nums.length; z++) {
                    int sum = nums[x] + nums[y] + nums[z];
                    if(isPrime(sum)) answer++;
                }
            }
        }
        
        return answer;
    }
}
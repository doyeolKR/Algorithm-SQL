class Solution {
    public static boolean[] prime;
    
    public void make_prime(int n) {
        prime = new boolean[n+1];
        
        if(n < 2) return;
        
        prime[0] = prime[1] = true;
        
        for(int i=2; i<=Math.sqrt(n); i++) {
            if(prime[i]) continue;
            
            for(int j=i*i; j<prime.length; j+=i) {
                prime[j] = true;
            }
        }
    }
    
    public int solution(int n) {
        int answer = 0;
        
        make_prime(n);
        
        for(int i=2; i<=n; i++) {
            if(!prime[i]) answer++;
        }
        
        return answer;
    }
}
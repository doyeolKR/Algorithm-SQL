class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        char[] arr = s.toCharArray();
        
        if(!(s.length()==4 || s.length()==6)) return answer = false;
        
        for(int i=0; i<arr.length; i++) {
            int val = arr[i];
            if(!(val<=57 && val>=48)) 
                answer = false; 
        }
        
        return answer;
    }
}
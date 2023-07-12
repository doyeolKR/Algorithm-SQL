class Solution {
    boolean solution(String s) {
        int pVal = 0;
        int yVal = 0;
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P') pVal++;
            else if(s.charAt(i) == 'y' || s.charAt(i) == 'Y') yVal++;
        }
        
        return pVal == yVal;
    }
}
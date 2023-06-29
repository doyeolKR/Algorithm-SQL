class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();     
        String[] words = s.split("");
        
        int idx = 0;
        
        for(int i=0; i<words.length; i++) {
            String word = words[i];
            
            if(word.equals(" ")) {
                idx = 0;
            }
            else {
                if(idx%2==0) word = word.toUpperCase();
                else word = word.toLowerCase();
                idx++;
            }
              
            sb.append(word);
        }
        
        return sb.toString();
    }
}
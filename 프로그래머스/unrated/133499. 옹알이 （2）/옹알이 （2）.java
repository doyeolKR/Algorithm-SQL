class Solution {
    private final String[] pronunciations = {
      "aya", "ye", "woo", "ma"  
    };
    
    private boolean check(String word) {
        String str = "";
        String pronunciation = "";
        for(char c : word.toCharArray()) {
            str += c;
            for(int i = 0; i < pronunciations.length; i++) {
                if(str.equals(pronunciations[i])) {
                    if(str.equals(pronunciation))
                        return false;
                    pronunciation = pronunciations[i];
                    str = "";
                }
            }
        }
        if(!str.equals("")) return false;
        else return true;
    }
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(int i = 0; i < babbling.length; i++) {
            String word = babbling[i];
            if(check(word))
                answer++;
        }
        return answer;
    }
}
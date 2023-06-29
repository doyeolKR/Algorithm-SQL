class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();     
        boolean toUpper = true;
        
        char[] arr = s.toCharArray();
        
        for(char c : arr) {
            if(!Character.isAlphabetic(c)) {
                sb.append(c);
                toUpper = true;
            }
            else {
                if(toUpper) sb.append(Character.toUpperCase(c));
                else sb.append(Character.toLowerCase(c));
                toUpper = !toUpper;
            }
        }
        
        return sb.toString();
    }
}
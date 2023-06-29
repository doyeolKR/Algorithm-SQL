class Solution {
    public char push(char c, int n) {
        if(!Character.isAlphabetic(c)) return c;
        
        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        int position = c - offset;
        position = (position + n) % 26;
        return (char)(offset + position);
    }
    
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        
        for(char c : arr) {
            sb.append(push(c,n));
        }
        return sb.toString();
    }
}
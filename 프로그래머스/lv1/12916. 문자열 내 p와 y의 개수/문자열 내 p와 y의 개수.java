class Solution {
    boolean solution(String s) {
        String str = s.toLowerCase();
        
        int ps = str.length() - str.replace("p", "").length();
        int ys = str.length() - str.replace("y", "").length();
        
        return ps == ys;
    }
}
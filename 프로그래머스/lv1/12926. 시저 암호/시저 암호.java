class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        int Znum = 'Z';
        int znum = 'z';
        
        char[] arr = s.toCharArray();
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i] >= 'A' && arr[i] <= 'Z') {
                arr[i] = (char)(arr[i] + n);
                if(arr[i] > Znum) {
                    arr[i] = (char)(arr[i] - 26);
                }
            }
            else if(arr[i] >= 'a' && arr[i] <= 'z') {
                arr[i] = (char)(arr[i] + n);
                if(arr[i] > znum) {
                    arr[i] = (char)(arr[i] - 26);
                }
            }
            answer += arr[i];
        }
        
        return answer;
    }
}
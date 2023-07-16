class Solution {
    static int[] arr1 = new int[10];
    static int[] arr2 = new int[10];
    static int[] arr3 = new int[10];
    
    public void makeArray(int[] arr, String str) {
        for(int i=0; i<str.length(); i++) {
            int num = str.charAt(i) - '0';
            arr[num]++;
        }
    }
    
    public String solution(String X, String Y) {
        makeArray(arr1, X);
        makeArray(arr2, Y);
        
        for(int i=0; i<10; i++) {
            if(arr1[i] <= arr2[i]) arr3[i] = arr1[i];
            else arr3[i] = arr2[i];
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--) {
            sb.append(String.valueOf(i).repeat(arr3[i]));
        }
        String answer = sb.toString();
        if(answer.equals("")) answer = "-1";
        else if(answer.matches("0+")) answer = "0";
        return answer;
    }
}
class Solution {
    public int inspection(String str, int i) {
        char c = str.charAt(i-1);
        if(String.valueOf(c).equals("0") && i-2 >= 0) {
            if(String.valueOf(str.charAt(i-2)).equals("1")) return 10;
        }
        return c - '0';
    }
    
    public int solution(String dartResult) {
        int[] arr = new int[3];
        
        int index = 0;
        
        for(int i=0; i<dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if(c == 'S') {
                int num = inspection(dartResult, i);
                arr[index++] = (int)Math.pow(num, 1);
            }
            else if(c == 'D') {
                int num = inspection(dartResult, i);
                arr[index++] = (int)Math.pow(num, 2);
            }
            else if(c == 'T') {
                int num = inspection(dartResult, i);
                arr[index++] = (int)Math.pow(num, 3);
            }
            else if(c == '*') {
                arr[index - 1] *= 2;
                if(index - 2 >= 0) arr[index - 2] *= 2;
            }
            else if(c == '#') {
                arr[index - 1] *= -1;
            }
        }
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        return arr[0] + arr[1] + arr[2];
    }
}
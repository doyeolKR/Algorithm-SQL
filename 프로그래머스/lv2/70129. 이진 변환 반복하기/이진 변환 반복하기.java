class Solution {
    public int[] solution(String s) {
        int zeroCount = 0;
        int changeCount = 0;
        
        while(!s.equals("1")) {
            String str = "";
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) - '0' == 1) str+="1";
                else zeroCount++;
            }
            s = Integer.toString(str.length(), 2);
            changeCount++;
        }
        int[] arr = new int[2];
        arr[1] = zeroCount;
        arr[0] = changeCount;
        return arr;
    }
}
class Solution {
    public int count(int num) {
        int cnt = 0;
        for(int i=1; i*i<=num; i++) {
            if(i * i == num) cnt++;
            else if(num % i == 0) cnt+=2; 
        }
        return cnt;
    }
    
    public int solution(int number, int limit, int power) {
        int sumAtt = 0;
        for(int i=1; i<=number; i++) {
            // 약수의 개수 구하기 
            int count = count(i);
            // limit 넘는지 학인하기
            int att = 0;
            if(limit >= count) att = count;
            else att = power;
            sumAtt += att;
        }
        return sumAtt;
    }
}
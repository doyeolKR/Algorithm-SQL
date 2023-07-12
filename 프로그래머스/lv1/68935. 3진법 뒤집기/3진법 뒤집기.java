import java.util.*;

class Solution {
    public int solution(int n) {
        String third = Integer.toString(n, 3);
        String reversed = new StringBuilder(third).reverse().toString();
        return Integer.parseInt(reversed, 3);
    }
}
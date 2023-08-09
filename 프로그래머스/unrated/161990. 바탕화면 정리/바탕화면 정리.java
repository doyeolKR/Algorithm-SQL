import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        for(int y = 0; y < wallpaper.length; y++) {
            for(int x = 0; x < wallpaper[y].length(); x++) {
                if(wallpaper[y].charAt(x) == '#') {
                    minX = Math.min(minX, x);
                    minY = Math.min(minY, y);
                    maxX = Math.max(maxX, x);
                    maxY = Math.max(maxY, y);
                }
            }
        }
        return new int[]{minY, minX, maxY + 1, maxX + 1};
    }
}
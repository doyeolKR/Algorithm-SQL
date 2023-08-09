import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int row = wallpaper.length;
        int col = wallpaper[0].length();
        
        char[][] screen = new char[row][col];
        
        for(int i = 0; i < row; i++) {
            screen[i] = wallpaper[i].toCharArray();
        }
        
        int[] direction = new int[4];
        direction[0] = row;
        direction[1] = col;
        direction[2] = 0;
        direction[3] = 0;
        
        for(int y = 0; y < screen.length; y++) {
            for(int x = 0; x < screen[0].length; x++) {
                if(screen[y][x] == '#') {
                    if(y < direction[0]) direction[0] = y;
                    if(x < direction[1]) direction[1] = x;
                    if(y >= direction[2]) direction[2] = y+1;
                    if(x >= direction[3]) direction[3] = x+1;
                }
            }
        }
        
        return direction;
    }
}
class Solution {
    public static final int[] dx = {0,-1,1,0};
    public static final int[] dy = {-1,0,0,1};
    
    public boolean isDistance(char[][] room) {
        for(int y=0; y<room.length; y++) {
            for(int x=0; x<room[y].length; x++) {
                if(room[y][x] != 'P') continue;            
                else if(!isDistance(room, x, y)) return false;
            }
        }
        return true;
    }
    
    public boolean isDistance(char[][] room, int x, int y) {
        for(int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(nx < 0 || ny < 0 || 
               ny >= room.length || nx >= room[ny].length) continue;
            
            switch(room[ny][nx]) {
                    case 'P': return false;
                    case 'O': 
                        if(isNextToVolunteer(room, ny, nx, 3 - d)) return false;
            }
        }
        return true;
    }
    
    public boolean isNextToVolunteer(char[][] room, int y, int x, int exclude) {
        for(int d=0; d<4; d++) {
            if(d == exclude) continue;
            
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(nx < 0 || ny < 0 || 
               ny >= room.length || nx>= room[ny].length) continue;
            if(room[ny][nx] == 'P') return true;
        }
        return false;
    }
    
    public int[] solution(String[][] places) {
        
        int[] answer = new int[places.length];
        
        for(int i=0; i<places.length; i++) {
            String[] place = places[i];
            char[][] room = new char[places.length][];
            
            for(int j=0; j<places.length; j++) {
                room[j] = place[j].toCharArray();
            }
            if(isDistance(room)) answer[i] = 1;
            else answer[i] = 0;
        }
        
        return answer;
    }
}
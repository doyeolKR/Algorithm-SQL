import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws Exception {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		
    		int N = Integer.parseInt(br.readLine());
    		boolean[] check;
    		int cnt = 0;
    		
    		for(int i=0; i<N; i++) {
    			String word = br.readLine();
    			check = new boolean[26];
    			
    			for(int j=0; j<word.length(); j++) {
    				if(j != 0 && check[word.charAt(j)-'a'] != false && word.charAt(j) != word.charAt(j-1) ) {
    					break;
    				}
    				else {
    					check[word.charAt(j)-'a'] = true;
    				}
    				if(j==word.length()-1) cnt++;
    			}
    			
    			
    		}
    		System.out.println(cnt);
    			

    }
}
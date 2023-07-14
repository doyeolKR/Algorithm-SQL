import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n==0) break;
            
            String[] str = new String[n];
            
            for(int i=0; i<n; i++) {
                str[i] = br.readLine();
            }
            Arrays.sort(str, String.CASE_INSENSITIVE_ORDER);
            System.out.println(str[0]);
        }
	}
}

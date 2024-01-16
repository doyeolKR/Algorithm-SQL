import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] A = new int[str.length()];

        for(int i = 0; i < A.length; i++) {
            A[i] = str.charAt(i) - '0';
        }

        for(int i = 0; i < A.length - 1; i++) {
            int max = A[i];
            int index = i;

            for(int j = i + 1; j < A.length; j++) {
                if(max < A[j]) {
                    max = A[j];
                    index = j;
                }
            }
            if(index != i) {
                A[index] = A[i];
                A[i] = max;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int num : A) {
            sb.append(num);
        }
        System.out.print(sb);

    } // main
}
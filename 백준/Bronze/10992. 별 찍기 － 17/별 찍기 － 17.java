import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N-1-i; j++) {
                sb.append(" ");
            }
            sb.append("*");
            if(i != N-1) {
                for(int k = N-i; k < N-1+i; k++) {
                    sb.append(" ");
                }
            }
            else {
                for(int k = N-i; k < N-1+i; k++) {
                    sb.append("*");
                }
            }
            if(i != 0) sb.append("*");
            if(i != N-1 ) sb.append("\n");
        }
        System.out.println(sb);
    }
}
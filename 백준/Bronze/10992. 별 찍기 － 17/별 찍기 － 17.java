import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N-1-i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            if(i != N-1) {
                for(int k = N-i; k < N-1+i; k++) {
                    System.out.print(" ");
                }
            }
            else {
                for(int k = N-i; k < N-1+i; k++) {
                    System.out.print("*");
                }
            }
            if(i != 0)System.out.print("*");
            if(i != N-1 )System.out.println();
        }
    }
}
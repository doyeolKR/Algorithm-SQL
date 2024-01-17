import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void swap(int[] A, int start, int end) {
        int tmp = A[start];
        A[start] = A[end];
        A[end] = tmp;
    }

    public static int partition(int[] A, int start, int end) {
        int pivot = A[(start + end) / 2];

        while(start <= end) {
            while(A[start] < pivot) start++;
            while(A[end] > pivot) end--;

            if(start <= end) {
                swap(A, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    public static void quickSort(int[] A, int start, int end) {
        int partition = partition(A, start, end);

        if(start < partition - 1) quickSort(A, start, partition -1);
        if(partition < end) quickSort(A, partition, end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(stz.nextToken());
        int K = Integer.valueOf(stz.nextToken());

        int[] A = new int[N];
        stz = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            A[i] = Integer.valueOf(stz.nextToken());
        }

        quickSort(A, 0, N-1);

        System.out.print(A[K-1]);

    } // main
}
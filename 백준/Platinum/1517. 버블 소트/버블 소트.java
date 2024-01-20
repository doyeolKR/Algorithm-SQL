import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static long result = 0;

    public static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
        for(int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }

        int index = start;
        int pointer1 = start;
        int pointer2 = mid + 1;

        while(pointer1 <= mid && pointer2 <= end) {
            if(tmp[pointer1] > tmp[pointer2]) {
                arr[index] = tmp[pointer2];
                result += pointer2 - index;
                pointer2++;
            }
            else {
                arr[index] = tmp[pointer1];
                pointer1++;
            }
            index++;

        }

        for(int i = 0; i <= mid - pointer1; i++) {
            arr[index + i] = tmp[pointer1 + i];
        }

    }

    public static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, tmp, start, mid);
            mergeSort(arr, tmp, mid + 1, end);
            merge(arr, tmp, start, mid, end);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        int[] arr = new int[N];
        int[] tmp = new int[N];

        StringTokenizer stz = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(stz.nextToken());
        }

        mergeSort(arr, tmp, 0, N-1);

        System.out.print(result);
    }
}
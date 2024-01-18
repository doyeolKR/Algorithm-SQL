import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
        for(int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }
        int point1 = start;
        int point2 = mid + 1;
        int index = start;

        while(point1 <= mid && point2 <= end) {
            if(tmp[point1] < tmp[point2]) {
                arr[index] = tmp[point1];
                point1++;
            }
            else {
                arr[index] = tmp[point2];
                point2++;
            }
            index++;
        }
        for(int i = 0; i <= mid - point1; i++) {
            arr[index + i] = tmp[point1 + i];
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

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(br.readLine());
        }

        mergeSort(arr, tmp, 0, N-1);

        StringBuilder sb = new StringBuilder();

        for(int num : arr) {
            sb.append(num).append("\n");
        }

        System.out.print(sb);

    } // main
}
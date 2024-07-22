import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 응시자 수
        int N = sc.nextInt();

        // 입상자 수
        int k = sc.nextInt();

        // 학생들 점수
        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
        }

        // 버블 정렬
        int[] sorted = bubbleSort(scores);
        System.out.println(sorted[N - k]);

    }

    static int[] bubbleSort(int[] arr) {
 
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1 ; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;

    }
}

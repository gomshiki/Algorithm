import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] A, B;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        A = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(arr[j]);
            }
        }

        String[] split1 = br.readLine().split(" ");
        K = Integer.parseInt(split1[1]);
        B = new int[M][K];
        for (int i = 0; i < M; i++) {
            String[] split2 = br.readLine().split(" ");
            for (int j = 0; j < K; j++) {
                B[i][j] = Integer.parseInt(split2[j]);
            }
        }
        multiple();
    }

    static void multiple() {
        int[][] temp = new int[N][K];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                for (int k = 0; k <M; k++) {
                    temp[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        debug(temp);
    }

    static void debug(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] split1 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(split1[j]);
            }
        }

        int K = Integer.parseInt(br.readLine());

        for (int l = 0; l < K; l++) {
            String[] split1 = br.readLine().split(" ");
            int i = Integer.parseInt(split1[0])-1;
            int j = Integer.parseInt(split1[1])-1;
            int x = Integer.parseInt(split1[2])-1;
            int y = Integer.parseInt(split1[3])-1;
            System.out.println(sum(i, j, x, y));
        }

    }

    static int sum(int i, int j, int x, int y) {
        int sum = 0;
        for (int k = i; k <= x; k++) {
            for (int l = j; l <= y; l++) {
                sum += arr[k][l];
            }
        }

        return sum;
    }
}

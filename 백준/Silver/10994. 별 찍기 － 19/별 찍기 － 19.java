import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static char[][] star;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt() - 1;
        sc.close();

        star = new char[4 * N + 1][4 * N + 1];

        // start 배열을빈칸으로 채운다
        for (char[] chars : star) {
            Arrays.fill(chars, ' ');
        }
        // 재귀함수 수행
        makingStar(N, 1);

        for (char[] chars : star) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }

    }

    static int makingStar(int N, int count) { // 3, 1
        if (N >= 0) {


            for (int i = 0; i < count; i++) {
                star[2 * N][2 * N + i] = '*'; // 위쪽
                star[2 * N + i][2 * N] = '*'; // 왼쪽

                star[2 * N + i][star[2 * N].length - (2 * N + 1)] = '*'; // 오른쪽
                star[star[2 * N].length - (2 * N + 1)][2 * N + i] = '*'; // 아래쪽
            }
            return makingStar(N - 1, count + 4);
        } else {
            return 0;
        }
    }
}

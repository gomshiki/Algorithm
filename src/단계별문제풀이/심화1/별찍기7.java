package 단계별문제풀이.심화1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 별찍기7 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        // 첫번째 줄부터 2N-1 줄까지 별을 출력

        for (int i = 0; i < (((2*N) - 1)/2) + 1; i++) {

            for (int j = N-1; j > i; j--) {
                System.out.print(" ");
            }

            for (int k = 0; k < (2*i) + 1; k++) {
                System.out.print("*");
            }

            System.out.println();

        }

        for (int i = 0; i < ((2*N) - 1)/2; i++) {

            for (int j = 0; j < i + 1; j++) {
                System.out.print(" ");
            }

            for (int k = 2 * N; k > (2 * i) + 3; k--) {
                System.out.print("*");
            }

            System.out.println();

        }



    }

}

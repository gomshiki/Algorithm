package 단계별문제풀이.수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 중앙이동알고리즘 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        double surface = Math.pow(4, N);

        double sqrt = Math.sqrt(surface);

        int nodes = (int) Math.pow(sqrt + 1, 2);

        System.out.println(nodes);
        /*

        // N == 1
            surface = 2 * 2; // 4 = 2^2 = 4^1
            nodes = 3 * 3; // 9
        
        // N == 2
            surface = 4 * 4 ; // 16 = 2^4 = 4^2
            nodes = 5 * 5;

        // N == 3
            surface = 8 * 8 ; // 64 = 2^8 = 4^3
            nodes = 9 * 9; // 81;

        */


    }

}

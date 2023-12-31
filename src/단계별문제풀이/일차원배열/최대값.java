package 단계별문제풀이.일차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최대값 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int count = 0;

        for (int i = 0; i < 9; i++) {
            int inputData = Integer.parseInt(br.readLine());

            if (max < inputData) {
                max = inputData;
                count  = i +1 ;
            }
        }

        System.out.println(max);
        System.out.println(count);
    }
}

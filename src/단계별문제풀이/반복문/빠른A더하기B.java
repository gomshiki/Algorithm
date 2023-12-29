package 단계별문제풀이.반복문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 빠른A더하기B {

    //15552번 빠른 A+B

    /**
     * for문 문제를 풀기 전에 주의해야 할 점이 있다. 입출력 방식이 느리면 여러 줄을 입력받거나 출력할 때 시간초과가 날 수 있다는 점이다.
     *
     * Java를 사용하고 있다면, Scanner와 System.out.println 대신 BufferedReader와 BufferedWriter를 사용할 수 있다.
     * BufferedWriter.flush는 맨 마지막에 한 번만 하면 된다.
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int inputData = Integer.parseInt(br.readLine());

        for (int i = 0; i < inputData; i++) {

            String[] split = br.readLine().split(" ");
            int sum = Integer.parseInt(split[0]) + Integer.parseInt(split[1]);

            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();
    }

}

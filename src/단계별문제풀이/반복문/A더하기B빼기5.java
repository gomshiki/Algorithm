package 단계별문제풀이.반복문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 마지막에 0,0 입력받으면 종료
public class A더하기B빼기5 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        while (true) {


            String[] s = br.readLine().split(" ");

            int sum = Arrays.stream(s).mapToInt(Integer::parseInt).sum();

            if (sum == 0) {break;}

            sb.append(sum+"\n");


        }
        System.out.println(sb.toString());

    }

}

package 단계별문제풀이.일차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 평균 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int qty = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        double max = (double) Arrays.stream(s).mapToInt(Integer::parseInt).max().getAsInt();

        double avg = Arrays.stream(s).mapToInt(Integer::parseInt)
                .mapToDouble(n -> n / max * 100.0).average().getAsDouble();

        System.out.println(avg);


    }

}

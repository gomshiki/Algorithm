package 단계별문제풀이.일차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최소최대 {

    // 풀이 1번 : 하드코딩
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());


        int max = -1000000;
        int min = 1000000;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num > max) max = num;
            if(num < min) min = num;
        }

        System.out.println(min + " " + max);

    }

    // 풀이2 : 스트림 이용
    static class solution2{

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int N = Integer.parseInt(br.readLine());

            String[] s = br.readLine().split(" ");

            int max = Arrays.stream(s).mapToInt(Integer::parseInt).max()
                    .getAsInt();
            int min = Arrays.stream(s).mapToInt(Integer::parseInt).min()
                    .getAsInt();

            System.out.println(min + " "+ max);

        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] score = new int[4];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            String fruit = split[0];
            int cnt = Integer.parseInt(split[1]);
            switch (fruit) {
                case "BANANA" :
                    score[0] += cnt;
                    break;
                case "STRAWBERRY":
                    score[1] += cnt;
                    break;
                case "LIME" :
                    score[2] += cnt;
                    break;
                case "PLUM" :
                    score[3] += cnt;
                    break;
            }

        }

        boolean isItFive = Arrays.stream(score).anyMatch(s -> s == 5);
        if (isItFive) System.out.println("YES");
        else System.out.println("NO");
    }
}

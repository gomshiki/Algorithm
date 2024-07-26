import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCaseCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCaseCnt; i++) {
            int outfitCnt = Integer.parseInt(br.readLine());

            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < outfitCnt; j++) {
                String[] split = br.readLine().split(" ");
                map.put(split[1], map.getOrDefault(split[1], 0) + 1);
            }

            int answer = 1;
            for (Integer value : map.values()) {
                answer *= (value + 1);
            }
            System.out.println(answer - 1);
        }
    }
}

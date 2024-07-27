import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        Map<String, Integer> map = new HashMap<>();
        map.put(S, 1);

        for (int k = 0; k < S.length() - 1; k++) {
            for (int j = 0; j < S.length() - k; j++) {
                String subString = S.substring(j, j + (k + 1));
                map.put(subString, map.getOrDefault(subString, 1));
            }
        }

        System.out.println(map.size());

         /* 반복되는 코드 리팩토링
            for (int i = 0; i < S.length() - 1; i++) {
                String substring = S.substring(i, i + 2);
                map.put(substring, map.getOrDefault(substring, 1));
            }

            for (int i = 0; i < S.length() - 2; i++) {
                String subString = S.substring(i, i + 3);
                map.put(subString, map.getOrDefault(subString, 1));
            }

            for (int i = 0; i < S.length() - 3; i++) {
                String subString = S.substring(i, i + 4);
                map.put(subString, map.getOrDefault(subString, 1));
            }*/


    }

}

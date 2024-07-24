import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 데이터 입력받기
        String[] chatInfo = new String[N];
        for (int i = 0; i < N; i++) {
            chatInfo[i] = br.readLine();
        }
        int cnt = 0;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < chatInfo.length; i++) {
            String s = chatInfo[i];
            if (s.equals("ENTER")) {
                cnt += set.size();
                set.clear();
            } else if (i == chatInfo.length -1) {
                set.add(s);
                cnt += set.size();
                set.clear();
            } else {
                set.add(s);
            }
        }
        System.out.println(cnt);
    }
}

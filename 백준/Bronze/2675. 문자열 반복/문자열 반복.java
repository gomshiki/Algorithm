import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            // 테스트 케이스 입력을 받는다.
            String[] split = br.readLine().split(" ");

            // 반복횟수를 int로 변환
            int repeatNum = Integer.parseInt(split[0]);

            // 타겟 String 초기화
            String target = split[1];


            for (int j = 0; j < target.length(); j++) {
                for (int k = 0; k < repeatNum; k++) {
                    sb.append(target.charAt(j));
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

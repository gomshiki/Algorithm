import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String X = br.readLine();

        int cnt = 0;
        while (X.length() > 1) {
            int sum = 0;
            for (int i = 0; i < X.length(); i++) {
                sum += X.charAt(i) - 48;
            }
            X = String.valueOf(sum);
            cnt++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n");

        int result = Integer.parseInt(X);
        if (result % 3 == 0) {
            sb.append("YES");
        }else {
            sb.append("NO");
        }

        System.out.println(sb);
    }
}

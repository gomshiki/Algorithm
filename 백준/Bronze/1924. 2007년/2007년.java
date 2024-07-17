import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String[] WEEK_DAY = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
    static int[] DAYS_OF_MONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        System.out.println(calculate(month, day));
    }

    static String calculate(int month, int day) {
        int sum = 0;

        // 1월 부터 (month -1)월까지 모든 일수를 더한다.
        for (int i = 0; i < month - 1; i++) {
            sum += DAYS_OF_MONTHS[i];
        }
        // 해당 달의 일수를 더한다.
        sum += day - 1;

        return WEEK_DAY[sum % 7];
    }
}

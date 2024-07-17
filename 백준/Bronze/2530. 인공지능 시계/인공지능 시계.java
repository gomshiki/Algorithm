import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] times = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int hour = times[0];
        int minute = times[1];
        int second = times[2];

        int takeSec = Integer.parseInt(br.readLine());

        // 요리시간 변환(시, 분, 초)
        int takeHour = takeSec / 3600;
        int takeMinute = takeSec % 3600 / 60;
        int takeSecond = takeSec % 60;

        // 초 계산
        int resultSec = (second + takeSecond) % 60;
        int carryMin = (second + takeSecond) / 60;

        // 분 계산
        int resultMin = (minute + takeMinute + carryMin) % 60;
        int carryHour = (minute + takeMinute + carryMin) / 60;

        // 시 계산
        int resultHour = (hour + takeHour + carryHour) % 24;


        System.out.println(resultHour + " " + resultMin + " " + resultSec);
    }
}

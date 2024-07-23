import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] light;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchCnt = Integer.parseInt(br.readLine()); // 스위치 개수
        light = new int[switchCnt + 1]; // 스위치 상태 0:Off , 1: on

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < switchCnt + 1; i++) {
            light[i] = Integer.parseInt(st.nextToken());
        }

        int studentCnt = Integer.parseInt(br.readLine()); // 학생 수

        List<Student> studentList = new ArrayList<>();

        // 학생 성별 및 스위치 번호 입력받기
        for (int i = 0; i < studentCnt; i++) {
            StringTokenizer studentInfo = new StringTokenizer(br.readLine());
            studentList.add(new Student(Integer.parseInt(studentInfo.nextToken()), Integer.parseInt(studentInfo.nextToken())));
        }

        for (Student student : studentList) {
            if (student.sex == 1) {
                maleSwitching(student.switchNum);
            } else {
                femaleSwitching(student.switchNum);
            }
        }
        print(light);
    }

    static void maleSwitching(int switchNum) {
        for (int i = switchNum; i < light.length; i += switchNum) {
            light[i] = light[i] == 0 ? 1 : 0;
        }

    }

    static void femaleSwitching(int switchNum) {
        // switchNum 변경
        light[switchNum] = light[switchNum] == 0 ? 1 : 0;

        int left = switchNum - 1;
        int right = switchNum + 1;

        while (left >= 1 && right < light.length && light[left] == light[right]) {
            light[left] = light[left] == 0 ? 1 : 0;
            light[right] = light[right] == 0 ? 1 : 0;
            left--;
            right++;
        }
    }

    static void print(int[] arr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");

            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    static class Student {
        int sex, switchNum;

        public Student(int sex, int switchNum) {
            this.sex = sex;
            this.switchNum = switchNum;
        }
    }
}


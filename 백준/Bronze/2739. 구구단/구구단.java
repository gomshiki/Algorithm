import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int inputData = Integer.parseInt(br.readLine());


        for (int i = 1; i < 10; i++) {
            sb.append(inputData + " * " + i + " = " + (inputData * i) +"\n");
        }

        System.out.println(sb);

    }

}
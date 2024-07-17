import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {

        /** 스트림 : 입력장치와 프로그램 사이 단방향으로 연결해주는 역할 **/
        /** InputStream :  입력받은 데이터를 바이트단위로 읽어드림(=Byte Stream) **/
        /** InputStreamReader : 문자단위로 읽어드림 (=Character Stream) **/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());


        if (a > b) {
            System.out.println(">");
        } else if (a < b) {
            System.out.println("<");
        } else {
            System.out.println("==");
        }


    }
}
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] splits = br.readLine().split(" ");

        int R = Integer.parseInt(splits[0]);
        int S = Integer.parseInt(splits[1]);

        char[][] picture = new char[R][S];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < S; j++) {
                    picture[i][j] = str.charAt(j);
            }
        }
        
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < picture[0].length; i++) {
            int lastX = -1;
            int firstHash = 0;
            for (int j = 0; j < picture.length; j++) {

                if (picture[j][i] == 'X') {
                    lastX = j;
                }
                if (picture[j][i] == '#') {
                    firstHash = j;
                    break;
                }
       
            }
            if(lastX != -1) {
                int distance = (R - lastX) - (R - firstHash) - 1;
                if (distance < min) {
                    min = distance;
                }
            }

            

        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < picture[0].length; i++) {
            for (int j = picture.length - 1; j >= 0; j--) {
                if (picture[j][i] == 'X') {
                    picture[j + min][i] = 'X';
                    picture[j][i] = '.';
                }
            }
        }

        for (char[] chars : picture) {
            for (char aChar : chars) {
                sb.append(aChar);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}

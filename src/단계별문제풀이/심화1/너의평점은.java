package 단계별문제풀이.심화1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class 너의평점은 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Double> scoreTable = new HashMap<>();
        HashMap<String, Double> userScoreTable = new HashMap<>();

        scoreTable.put("A+", 4.5);
        scoreTable.put("A0", 4.0);
        scoreTable.put("B+", 3.5);
        scoreTable.put("B0", 3.0);
        scoreTable.put("C+", 2.5);
        scoreTable.put("C0", 2.0);
        scoreTable.put("D+", 1.5);
        scoreTable.put("D0", 1.0);
        scoreTable.put("F", 0.0);

        String[] getScores = new String[20];
        double[] getClass = new double[20];

        for (int i = 0; i < 20; i++) {

            String[] inputDatas = br.readLine().split(" ");

            // 평과 과목이 P 면 평균점수에서 제외
            if (inputDatas[2].equals("P")) {
                continue;
            }
            userScoreTable.put(inputDatas[2], Double.parseDouble(inputDatas[1]));
        }

        double sum = 0;

        for (int i = 0; i < userScoreTable.size(); i++) {

            // 1. 학생이 얻은 등급
            userScoreTable.

        }


    }

}

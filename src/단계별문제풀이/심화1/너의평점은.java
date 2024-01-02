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

        scoreTable.put("A+", 4.5);
        scoreTable.put("A0", 4.0);
        scoreTable.put("B+", 3.5);
        scoreTable.put("B0", 3.0);
        scoreTable.put("C+", 2.5);
        scoreTable.put("C0", 2.0);
        scoreTable.put("D+", 1.5);
        scoreTable.put("D0", 1.0);
        scoreTable.put("F", 0.0);


        double sum = 0;
        double totalScore = 0;

        // 전공평점은 전공과목별 (학점 × 과목평점)의 합을 학점의 총합으로 나눈 값이다.

        for (int i = 0; i < 20; i++) {

            String[] inputDatas = br.readLine().split(" ");

            // 평과 과목이 P 면 평균점수에서 제외
            if (inputDatas[2].equals("P")) {
                continue;
            }


            // 취득학점
            double score = Double.parseDouble(inputDatas[1]);

            // 학점 총합
            totalScore += score;

            String grade = inputDatas[2];

            // 과목 평점
            double standardScore = scoreTable.get(grade);

            // (학점 * 과목평점)의 총합
            sum += standardScore * score;



        }

        System.out.println(sum / totalScore);







    }

}

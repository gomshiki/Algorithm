package 개념정리;

public class floatdouble연산문제 {

    public static void main(String[] args) {

        float a = 1.0f;
        double b = 2.0;


        for (int i = 0; i < 100; i++) {

            a += 0.0001 ;
            b += 0.001 ;

        }

        System.out.println("b = " + b);
        System.out.println("a = " + a);



    }

}

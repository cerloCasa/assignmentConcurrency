package myMathQuiz;

import java.util.Random;

public class NumericQuestion {
    private int num1;
    private int num2;
    private String operator;

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public String getOperator() {
        return operator;
    }

    public void randomInit() {
        Random random = new Random();
        num1 = random.nextInt(100);
        num2 = random.nextInt(100);
        operator = random.nextInt() % 2 == 0 ? "+" : "-";
    }

    public int getResult() {
        if (operator.equals("+"))
            return num1 + num2;
        else
            return num1 - num2;
    }

    public String toString() {
        return num1 + " " + operator + " " + num2 + " =";
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            NumericQuestion q = new NumericQuestion();
            q.randomInit();
            System.out.println(q + " " + q.getResult());
        }
    }
}
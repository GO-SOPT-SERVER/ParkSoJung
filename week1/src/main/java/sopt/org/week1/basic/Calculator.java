package sopt.org.week1.basic;

public class Calculator {
    private Character operator;

    // 오버로딩: 같은 이름의 메서드가 다른 타입으로 동작
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }
}

package sopt.org.week1.basic;

// 추상화: 가장 본질적이고 공통적인 부분만 사용
public abstract class Person {
    private String gender;
    private int age;
    private String name;
    private boolean isMarried;

    public abstract void walk();

}

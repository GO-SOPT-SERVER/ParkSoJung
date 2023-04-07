package sopt.org.week1;

public class Dog extends Animal {
    private String gender;

    public void walk() {
        System.out.println("강아지가 산책을 합니다.");
    }

    // 오버라이딩: 부모 클래스의 메서드 동작 재정의
    @Override
    public void speak() {
        System.out.println("월월");
    }

}

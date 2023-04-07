package sopt.org.week1;

// 인터페이스 상속
public class SportsCar implements Car{

    @Override
    public void turnOn() {
        System.out.println("스포츠카 시동 켜기");
    }

    @Override
    public void turnOff() {
        System.out.println("스포츠카 시동 끄기");
    }
}

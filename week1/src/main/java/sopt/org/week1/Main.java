package sopt.org.week1;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		// 클래스 객체 생성
		Animal animal = new Animal();
		animal.speak();
		animal.drink();

		ConvenienceStore firstGS = new ConvenienceStore("GS25", "우리 집 앞", 8, 0);
		firstGS.addStaffCount();
		firstGS.addVisitorCOunt();
		firstGS.printConvenienceStoreInfo();

		Calculator calculator = new Calculator();
		int intResult = calculator.add(1, 10);
		double doubleResult = calculator.add(1, 10);
		System.out.println("intResult = " + intResult);
		System.out.println("doubleResult = " + doubleResult);

	}

}

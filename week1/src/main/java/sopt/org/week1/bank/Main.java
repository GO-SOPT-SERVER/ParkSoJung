package sopt.org.week1.bank;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class Main {

    static Scanner scanner;
    public static ArrayList<User> userList;
    public static ArrayList<Account> aAccountList;
    public static ArrayList<SavingAccount> sAccountList;

    public static void main(String[] args) {
        userList = new ArrayList<>();
        aAccountList = new ArrayList<>();
        sAccountList = new ArrayList<>();
        run();
    }

    private static void run() {
        Exit:
        while (true) {
            System.out.println("------------------- 🏦 솝트 은행 🏦 -------------------");
            System.out.println("1. 로그인 | 2. 회원 가입 | 0. 종료");
            System.out.print("번호를 입력해주세요: ");
            switch (scanner.nextInt()) {
                case 1:
                    break;
                case 2:
                    break;
                case 0:
                    break Exit;
            }
        }
    }
}

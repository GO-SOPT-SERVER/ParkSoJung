package sopt.org.week1.bank;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner;
    public static ArrayList<User> userList;
    public static ArrayList<Account> aAccountList;
    public static ArrayList<SavingAccount> sAccountList;
    private static User user;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        userList = new ArrayList<>();
        aAccountList = new ArrayList<>();
        sAccountList = new ArrayList<>();
        user = new User();
        run();
    }

    private static void run() {
        while (true) {
            System.out.println("------------------- 🏦 솝트 은행 🏦 -------------------");
            System.out.println("1. 로그인 | 2. 회원 가입 | 0. 종료");
            System.out.print("번호를 입력해주세요: ");
            switch (scanner.nextInt()) {
                case 1:
                    login();
                    break;
                case 2:
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("** 없는 메뉴입니다. **");
                    run();
                    break;
            }
        }
    }

    private static void login() {
        System.out.println("------------------- 로그인 -------------------");
        System.out.print("주민등록번호: ");
        String ssn = scanner.next();
        System.out.print("비밀번호: ");
        String password = scanner.next();

        if(!user.getUser(ssn)) {
            System.out.println("** 존재하지 않는 유저입니다. **");
            run();
        } else if(!user.login(ssn, password)) {
            System.out.println("** 비밀번호가 맞지 않습니다. **");
            run();
        } else showMenu();
    }

    private static void showMenu() {
        System.out.println("1. 예금 | 2. 출금 | 3. 계좌 조회 | 0. 로그아웃");
        System.out.print("번호를 입력해주세요: ");
    }

}

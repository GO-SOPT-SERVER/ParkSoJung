package sopt.org.week1.bank;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner;
    public static ArrayList<User> userList;
    public static ArrayList<Account> aAccountList;
    public static ArrayList<SavingAccount> sAccountList;
    private static User user;
    private static CheckingAccount checkingAccount;
    private static SavingAccount savingAccount;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        userList = new ArrayList<>();
        aAccountList = new ArrayList<>();
        sAccountList = new ArrayList<>();
        user = new User();
        checkingAccount = new CheckingAccount();
        savingAccount = new SavingAccount();
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
                    join();
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

        if(!user.isUser(ssn)) {
            System.out.println("** 존재하지 않는 유저입니다. **");
            run();
        } else if(!user.login(ssn, password)) {
            System.out.println("** 비밀번호가 맞지 않습니다. **");
            run();
        } else {
            user = user.getUser(ssn);
            showMenu();
        }
    }

    private static void join() {
        System.out.println("------------------- 회원가입 -------------------");
        System.out.print("이름: ");
        String name = scanner.next();
        System.out.print("주민등록번호: ");
        String ssn = scanner.next();
        System.out.print("비밀번호: ");
        String password = scanner.next();

        user.join(name, ssn, password);
        System.out.println(name + "님 솝트 은행에 가입되셨습니다!");
    }

    private static void showMenu() {
        System.out.println("1. 예금 | 2. 출금 | 3. 계좌 조회 | 4. 계좌 개설 | 0. 로그아웃");
        System.out.print("번호를 입력해주세요: ");
        switch (scanner.nextInt()) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                createAccount();
                showMenu();
                break;
            case 0:
                break;
            default:
                System.out.println("** 없는 메뉴입니다. **");
                break;
        }

    }

    private static void createAccount() {
        System.out.println("개설 하실 계좌 종류를 선택해주세요.");
        System.out.println("1. 입출금 계좌 | 2. 적금 계좌 | 0. 뒤로가기");
        switch (scanner.nextInt()) {
            case 1:
                createCAccount();
                break;
            case 2:
                createSAccount();
                break;
            case 0:
                break;
            default:
                break;
        }
    }

    private static void createSAccount() {
        String number = checkingAccount.create(user);
        System.out.println("정상적으로 개설되었습니다! (계좌번호: "+number+")");
    }


    private static void createCAccount() {
        String number = savingAccount.create(user);
        System.out.println("정상적으로 개설되었습니다! (계좌번호: "+number+")");
    }

}
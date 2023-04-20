package sopt.org.week1.bank;

import java.util.List;
import java.util.stream.Collectors;

import static sopt.org.week1.bank.Main.cAccountList;

public class CheckingAccount extends Account{

    public CheckingAccount() {
    }

    public CheckingAccount(User user, String number, int totalAmount) {
        super(user, number, totalAmount);
    }

    @Override
    public String create(User user) {
        CheckingAccount account = new CheckingAccount(user, String.valueOf((int)(Math.random() * (99999 - 10000 + 1)) + 10000), 0);
        account.setId((long) (cAccountList.size()+1));
        cAccountList.add(account);
        return account.getNumber();
    }

    @Override
    public String getAccountInfo(User user) {
        long isAccount = cAccountList.stream()
                .filter(a -> a.getUser().equals(user)).count();
        if(isAccount == 0) return "개설된 입출금 계좌가 없습니다.";

        List<CheckingAccount> accountList = cAccountList.stream()
                .filter(a -> a.getUser().equals(user)).collect(Collectors.toList());
        return toString(accountList);
    }

    @Override
    public void deposit(String number, int amount) {
        if(isExistAccount(number) == 0) System.out.println("존재하지 않는 입출금 계좌입니다.");
        else {
            CheckingAccount account = getAccount(number);
            account.setTotalAmount(account.getTotalAmount() + amount);
            cAccountList.set(Math.toIntExact(account.id - 1), account);
            System.out.println("계좌 총 금액: " + account.getTotalAmount());
        }
    }

    @Override
    public CheckingAccount getAccount(String number) {
        return cAccountList.stream()
                .filter(a -> a.getNumber().equals(number)).findAny().orElse(null);
    }

    public void withdraw(String number, int amount) {
        if(isExistAccount(number) == 0) System.out.println("존재하지 않는 입출금 계좌입니다.");
        else {
            CheckingAccount account = getAccount(number);
            if (amount > account.getTotalAmount()) System.out.println("출금 금액이 총 금액보다 큽니다.");
            else {
                account.setTotalAmount(account.getTotalAmount() - amount);
                cAccountList.set(Math.toIntExact(account.id - 1), account);
                System.out.println("계좌 총 금액: " + account.getTotalAmount());
            }
        }
    }

    public String toString(List<CheckingAccount> accountList) {
        String accountInfo = "계좌번호 | 금액 " + System.lineSeparator() ;
        for(CheckingAccount a : accountList) {
            accountInfo = accountInfo + a.number + " | " + a.totalAmount + System.lineSeparator();
        }
        return accountInfo;
    }

    private static long isExistAccount(String number) {
        return cAccountList.stream()
                .filter(a -> a.getNumber().equals(number)).count();
    }


}

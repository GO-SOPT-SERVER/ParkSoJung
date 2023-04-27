package sopt.org.week1.advanced;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import static sopt.org.week1.advanced.Main.sAccountList;

public class SavingAccount extends Account {
    private LocalDateTime expiration;

    public SavingAccount() {
    }

    public SavingAccount(User user, String number, int totalAmount) {
        super(user, number, totalAmount);
        this.expiration = LocalDateTime.now().plusYears(1);
    }

    @Override
    public String create(User user) {
        SavingAccount account = new SavingAccount(user, String.valueOf((int)(Math.random() * (99999 - 10000 + 1)) + 10000), 0);
        account.setId((long) (sAccountList.size()+1));
        sAccountList.add(account);
        return account.getNumber();
    }

    @Override
    public String getAccountInfo(User user) {
        long isAccount = sAccountList.stream()
                .filter(a -> a.getUser().equals(user)).count();
        if(isAccount == 0) return "개설된 적금 계좌가 없습니다.";

        List<SavingAccount> accountList = sAccountList.stream()
                .filter(a -> a.getUser().equals(user)).collect(Collectors.toList());
        return toString(accountList);
    }

    @Override
    public void deposit(String number, int amount) {
        long isAccount = sAccountList.stream()
                .filter(a -> a.getNumber().equals(number)).count();
        if(isAccount == 0) System.out.println("존재하지 않는 적금 계좌입니다.");

        SavingAccount account = getAccount(number);
        account.setTotalAmount(account.getTotalAmount()+amount);
        sAccountList.set(Math.toIntExact(account.id-1), account);

        System.out.println("계좌 총 금액: " + account.getTotalAmount());
    }

    @Override
    public SavingAccount getAccount(String number) {
        return sAccountList.stream()
                .filter(a -> a.getNumber().equals(number)).findAny().orElse(null);
    }

    public String toString(List<SavingAccount> accountList) {
        String accountInfo = "계좌번호 | 금액 | 만기일 " + System.lineSeparator() ;
        for(SavingAccount a : accountList) {
            accountInfo = accountInfo + a.number + " | " + a.totalAmount + " | " + a.expiration.format(DateTimeFormatter.ofPattern("yyyyMMdd")) + System.lineSeparator();
        }
        return accountInfo;
    }

}

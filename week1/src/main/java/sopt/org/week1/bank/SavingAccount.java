package sopt.org.week1.bank;

import java.time.LocalDateTime;

import static sopt.org.week1.bank.Main.sAccountList;

public class SavingAccount extends Account {
    private LocalDateTime expiration;

    @Override
    public String create(User user) {
        SavingAccount account = new SavingAccount(user, String.valueOf((int)(Math.random() * (99999 - 10000 + 1)) + 10000), 0);
        account.setId((long) (sAccountList.size()+1));
        sAccountList.add(account);
        return account.getNumber();
    }

    public SavingAccount(User user, String number, int totalAmount) {
        super(user, number, totalAmount);
        this.expiration = LocalDateTime.now().plusYears(1);
    }

    public SavingAccount() {
    }
}

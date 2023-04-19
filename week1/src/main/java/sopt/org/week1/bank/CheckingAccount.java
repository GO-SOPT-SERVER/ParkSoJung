package sopt.org.week1.bank;

import static sopt.org.week1.bank.Main.aAccountList;

public class CheckingAccount extends Account{

    public CheckingAccount() {
    }

    public CheckingAccount(User user, String number, int totalAmount) {
        super(user, number, totalAmount);
    }

    @Override
    public String create(User user) {
        CheckingAccount account = new CheckingAccount(user, String.valueOf((int)(Math.random() * (99999 - 10000 + 1)) + 10000), 0);
        account.setId((long) (aAccountList.size()+1));
        aAccountList.add(account);
        return account.getNumber();
    }

    public String withdraw(String number, int amount) {
        return null;
    }


}

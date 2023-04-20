package sopt.org.week1.bank;


public abstract class Account {
    Long id;
    User user;
    String number;
    int totalAmount;

    public Account() {
    }

    public abstract String create(User user);
    public abstract String getAccountInfo(User user);
    public abstract void deposit(String number, int amount);
    public abstract Account getAccount(String number);

    public Account(User user, String number, int totalAmount) {
        this.user = user;
        this.number = number;
        this.totalAmount = totalAmount;
    }

    public String getNumber() {
        return number;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}

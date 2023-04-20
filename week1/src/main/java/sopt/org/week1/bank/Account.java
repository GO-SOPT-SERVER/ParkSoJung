package sopt.org.week1.bank;


public abstract class Account {
    Long id;
    User user;
    String number;
    int totalAmount;

    public Account() {
    }

    public Account(User user, String number, int totalAmount) {
        this.user = user;
        this.number = number;
        this.totalAmount = totalAmount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public User getUser() {
        return user;
    }

    public abstract String create(User user);
    public abstract String getAccountInfo(User user);
    public abstract String deposit(String number, int amount);
}

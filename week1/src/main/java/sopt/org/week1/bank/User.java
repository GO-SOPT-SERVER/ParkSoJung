package sopt.org.week1.bank;

import java.util.Optional;
import java.util.stream.Collectors;

import static sopt.org.week1.bank.BaseStatus.INVALID_USER;
import static sopt.org.week1.bank.Main.userList;

public class User {
    private Long id;
    private String name;
    private String ssn;
    private String password;

    public User() {
    }



    public boolean getUser(String ssn) {
        long isUser = userList.stream()
                .filter(u -> u.getSsn().equals(ssn)).count();
        return isUser != 0;
    }

    public boolean login(String ssn, String password) {
        User user = userList.stream()
                .filter(u -> u.getSsn().equals(ssn))
                .findFirst().orElse(null);
        if(user.getPassword().equals(password)) return true;
        return false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

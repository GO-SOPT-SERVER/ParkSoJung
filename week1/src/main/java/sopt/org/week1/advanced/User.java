package sopt.org.week1.advanced;

import static sopt.org.week1.advanced.Main.userList;

public class User {
    private Long id;
    private String name;
    private String ssn;
    private String password;

    public User() {
    }

    public User(String name, String ssn, String password) {
        this.name = name;
        this.ssn = ssn;
        this.password = password;
    }

    public boolean isUser(String ssn) {
        long isUser = userList.stream()
                .filter(u -> u.getSsn().equals(ssn)).count();
        return isUser != 0;
    }

    public User getUser(String ssn) {
        return userList.stream()
                .filter(u -> u.getSsn().equals(ssn))
                .findFirst().orElse(null);
    }

    public boolean login(String ssn, String password) {
        User user = getUser(ssn);
        if(user.getPassword().equals(password)) return true;
        return false;
    }

    public void join(String name, String ssn, String password) {
        User user = new User(name, ssn, password);
        user.setId((long) (userList.size()+1));
        userList.add(user);
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
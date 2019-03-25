package com.tgy.springboot2.xbook.springboot2xbookc10;

/**
 * @ClassName User
 */
public class User {
    private String userName;
    private String note;

    public User(String userName, String note) {
        this.userName = userName;
        this.note = note;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}

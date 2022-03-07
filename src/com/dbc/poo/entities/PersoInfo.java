package com.dbc.poo.entities;

public class PersoInfo {
    private String realName;
    private int age;
    private String email;

    public PersoInfo(String realName, int age, String email) {
        this.realName = realName;
        this.age = age;
        this.email = email;
    }

    public PersoInfo() {
    }

    public String getRealName() {
        return realName;
    }
    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void printPersoInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "PersoInfo{" +
                "realName='" + realName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}

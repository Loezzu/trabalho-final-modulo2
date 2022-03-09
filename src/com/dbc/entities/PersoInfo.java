package com.dbc.entities;

public class PersoInfo {

    private Integer idPersoInfo;
    private String realName;
    private Integer age;
    private String email;

    public Integer getIdPersoInfo() {
        return idPersoInfo;
    }
    public void setIdPersoInfo(Integer idPersoInfo) {
        this.idPersoInfo = idPersoInfo;
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
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PersoInfo{" +
                "idPersoInfo=" + idPersoInfo +
                ", realName='" + realName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
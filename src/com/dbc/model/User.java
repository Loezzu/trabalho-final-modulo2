package com.dbc.model;

import com.dbc.enums.Gender;
import com.dbc.enums.Pref;
import com.dbc.enums.ProgLangs;

public class User {

    private Integer userId;
    private String username;
    private String password;
    private PersoInfo persoInfo;
    private Address address;
    private ProgLangs progLangs;
    private Gender gender;
    private Pref pref;

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public PersoInfo getPersoInfo() {
        return persoInfo;
    }
    public void setPersoInfo(PersoInfo persoInfo) {
        this.persoInfo = persoInfo;
    }

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public ProgLangs getProgLangs() {
        return progLangs;
    }
    public void setProgLangs(ProgLangs progLangs) {
        this.progLangs = progLangs;
    }

    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Pref getPref() {
        return pref;
    }
    public void setPref(Pref pref) {
        this.pref = pref;
    }

    @Override
    public String toString() {
        return "User {"
                + "User ID = " + userId
                + " - Username = " + username
                + " - Password = " + password
                + " - PersoInfo = " + persoInfo
                + " - Address = " + address
                + " - ProgLangs = " + progLangs
                + " - Gender = " + gender
                + " - Pref = " + pref + "}";
    }
}
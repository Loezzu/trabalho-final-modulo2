package com.dbc.poo.entities;

import com.dbc.poo.enums.Gender;
import com.dbc.poo.enums.Pref;
import com.dbc.poo.enums.ProgLangs;

import java.util.ArrayList;
import java.util.List;

public abstract class User{
    private String username;
    private String password;
    private PersoInfo persoInfo;
    private Address address;
    private ProgLangs progLangs;
    private Gender gender;
    private Pref pref;

    private final List<User> myMatches = new ArrayList<>();
    private final List<User> myLikes = new ArrayList<>();


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

    public List<User> getMyMatches() {
        return myMatches;
    }
    public List<User> getMyLikes() {
        return myLikes;
    }

    public User() {
    }

    public User(String username, String password, PersoInfo persoInfo, Address address, ProgLangs progLangs, Gender gender, Pref pref) {
        this.username = username;
        this.password = password;
        this.persoInfo = persoInfo;
        this.address = address;
        this.progLangs = progLangs;
        this.gender = gender;
        this.pref = pref;
    }

    public void printMyInfo() {
        System.out.println(this);
    }
    public void printMyMatches() {
        for (User myMatch : myMatches) {
            System.out.println("Nome: " + myMatch.getPersoInfo().getRealName() + " | Idade: " + myMatch.getPersoInfo().getAge() + " | Linguagem de Programação: " + myMatch.progLangs);
        }
    }
    public void printMyLikes() {
        for (User myLike : myLikes) {
            System.out.println("Nome: " + myLike.getPersoInfo().getRealName() + " | Idade: " + myLike.getPersoInfo().getAge() + " | Linguagem de Programação: " + myLike.progLangs);
        }

    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + username + '\'' +
                ", persoInfo=" + persoInfo +
                ", address=" + address +
                ", progLangs=" + progLangs +
                ", gender=" + gender +
                ", pref=" + pref +
                '}';
    }
}

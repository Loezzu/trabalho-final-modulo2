package com.dbc.poo.entities;

import com.dbc.poo.enums.Gender;
import com.dbc.poo.enums.Pref;
import com.dbc.poo.enums.ProgLangs;
import com.dbc.poo.interfaces.Print;

public class FreeUser extends User implements Print {
    public FreeUser() {
    }

    public FreeUser(String username, String password, PersoInfo persoInfo, Address address, ProgLangs progLangs, Gender gender, Pref pref) {
        super(username, password, persoInfo, address, progLangs, gender, pref);
    }

    @Override
    public void printMyInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "FreeUser{" +
                "username='" + getUsername() + '\'' +
                ", persoInfo=" + getPersoInfo() +
                ", address=" + getAddress() +
                ", progLangs=" + getProgLangs() +
                ", gender=" + getGender() +
                ", pref=" + getPref() +
                '}';
    }
}


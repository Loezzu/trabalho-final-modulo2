package com.dbc.poo.entities;

import com.dbc.poo.entities.Address;
import com.dbc.poo.entities.PersoInfo;
import com.dbc.poo.entities.User;
import com.dbc.poo.enums.Gender;
import com.dbc.poo.enums.Pref;
import com.dbc.poo.enums.ProgLangs;
import com.dbc.poo.interfaces.Print;

public class ProUser extends User implements Print {
    private String whatsApp;

    public ProUser() {
    }

    public ProUser(String username, String password, PersoInfo persoInfo, Address address, ProgLangs progLangs, Gender gender, Pref pref, String whatsApp) {
        super(username, password, persoInfo, address, progLangs, gender, pref);
        this.whatsApp = whatsApp;
    }

    public String getWhatsApp() {
        return whatsApp;
    }
    public void setWhatsApp(String whatsApp) {
        this.whatsApp = whatsApp;
    }

    @Override
    public void printMyInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "ProUser{" +
                "username='" + getUsername() + '\'' +
                ", persoInfo=" + getPersoInfo() +
                ", address=" + getAddress() +
                ", progLangs=" + getProgLangs() +
                ", gender=" + getGender() +
                ", pref=" + getPref() +
                ", whatsApp=" + getWhatsApp() +
                '}';
    }
}

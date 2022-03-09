package com.dbc;

import com.dbc.entities.Address;
import com.dbc.entities.PersoInfo;
import com.dbc.entities.User;
import com.dbc.enums.Gender;
import com.dbc.enums.Pref;
import com.dbc.enums.ProgLangs;
import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.service.AddressService;
import com.dbc.service.PersoInfoService;
import com.dbc.service.UserService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws BancoDeDadosException {
        Menu menu = new Menu();

        menu.appInit();
    }
}

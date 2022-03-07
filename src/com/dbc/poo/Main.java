package com.dbc.poo;

import com.dbc.poo.entities.*;
import com.dbc.poo.enums.Gender;
import com.dbc.poo.enums.Pref;
import com.dbc.poo.enums.ProgLangs;

public class Main {

    public static void main(String[] args) {

    UserActions userAct = new UserActions();

        User romeu = new ProUser("romeu", "1234",
                new PersoInfo("Romeu", 25, "romeu@mail.com"),
                new Address("Rua Romeu",7,"Porto Alegre"),
                ProgLangs.JAVASCRIPT, Gender.MALE, Pref.WOMEN, "9991");

        User leandro = new FreeUser("leandro", "2345",
                new PersoInfo("Leandro", 20, "leandro@mail.com"),
                new Address("Rua Leandro",8,"Cachoeirinha"),
                ProgLangs.JAVA, Gender.MALE, Pref.MEN);

        User beto = new ProUser("beto", "3456",
                new PersoInfo("Alberto", 19, "beto@mail.com"),
                new Address("Rua Beto",9,"Gravataí"),
                ProgLangs.PHP, Gender.MALE, Pref.BOTH, "9993");

        User joana = new FreeUser("joana", "4567",
                new PersoInfo("Joana", 32, "joana@mail.com"),
                new Address("Rua Joana",45,"Canoas"),
                ProgLangs.C, Gender.FEMALE, Pref.WOMEN);

        User marina = new ProUser("marina", "6789",
                new PersoInfo("Marina", 22, "marina@mail.com"),
                new Address("Rua Mari",365,"Viamão"),
                ProgLangs.JAVASCRIPT, Gender.FEMALE, Pref.MEN, "9995");

        User adriele = new FreeUser("adri", "7890",
                new PersoInfo("Adriele", 20, "adri@mail.com"),
                new Address("Rua Adri",85,"Esteio"),
                ProgLangs.TYPESCRIPT, Gender.FEMALE, Pref.BOTH);

        User ibson = new ProUser("ibson", "8901",
                new PersoInfo("Ibson", 29, "ibson@mail.com"),
                new Address("Rua Ibson",12,"Novo Hamburgo"),
                ProgLangs.RUBY, Gender.MALE, Pref.WOMEN, "9997");

        User julia = new FreeUser("julia", "9012",
                new PersoInfo("Julia", 18, "julia@mail.com"),
                new Address("Rua Julia",3,"Glorinha"),
                ProgLangs.JAVASCRIPT, Gender.FEMALE, Pref.MEN);

        User marcio = new ProUser("marcio", "0123",
                new PersoInfo("Marcio", 22, "marcio@mail.com"),
                new Address("Rua Marcio",12,"Porto Alegre"),
                ProgLangs.JAVA, Gender.MALE, Pref.MEN, "9999");

        User vitoria = new FreeUser("joana", "1234",
                new PersoInfo("Guilherme", 20, "gui@mail.com"),
                new Address("Rua Gui",8,"Cachoeirinha"),
                ProgLangs.PHP, Gender.FEMALE, Pref.WOMEN);

        User marcelo = new FreeUser("marcelo", "4567",
                new PersoInfo("Marcelo", 32, "marcelo@mail.com"),
                new Address("Rua Marcelo",45,"Gravataí"),
                ProgLangs.C, Gender.MALE, Pref.BOTH);

        User thiago = new ProUser("thiago", "6789",
                new PersoInfo("Thiago", 22, "thiago@mail.com"),
                new Address("Rua Thiago",365,"Viamão"),
                ProgLangs.PYTHON, Gender.MALE, Pref.BOTH, "9995");

        User luiza = new FreeUser("luiza", "7890",
                new PersoInfo("Luiza", 20, "luiza@mail.com"),
                new Address("Rua Luiza",85,"Esteio"),
                ProgLangs.TYPESCRIPT, Gender.FEMALE, Pref.WOMEN);

        User camila = new ProUser("camila", "8901",
                new PersoInfo("Camila", 29, "camila@mail.com"),
                new Address("Rua Camila",12,"Canoas"),
                ProgLangs.RUBY, Gender.FEMALE, Pref.MEN, "9997");

        UserActions.userList.add(romeu);
        UserActions.userList.add(leandro);
        UserActions.userList.add(beto);
        UserActions.userList.add(joana);
        UserActions.userList.add(marina);
        UserActions.userList.add(adriele);
        UserActions.userList.add(ibson);
        UserActions.userList.add(julia);
        UserActions.userList.add(marcio);
        UserActions.userList.add(vitoria);
        UserActions.userList.add(marcelo);
        UserActions.userList.add(thiago);
        UserActions.userList.add(luiza);
        UserActions.userList.add(camila);

        userAct.appInit();
    }
}


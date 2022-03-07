package com.dbc.poo.tests;

import com.dbc.poo.entities.*;
import com.dbc.poo.enums.Gender;
import com.dbc.poo.enums.Pref;
import com.dbc.poo.enums.ProgLangs;
import org.junit.Test;


import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserActionsTest {

    private UserActions userAct;

    @Test
    public void mustRegisterUser() {

        //SETUP
        UserActions userAct = new UserActions();

        User user = new FreeUser();
        user.setUsername("luiz");
        user.setPassword("1234");
        PersoInfo persoInfo = new PersoInfo("Luiz", 19, "luiz@mail.com");
        user.setPersoInfo(persoInfo);
        user.setAddress(new Address("Rua A", 123, "Gravataí"));
        user.setProgLangs(ProgLangs.JAVA);
        user.setGender(Gender.MALE);
        user.setPref(Pref.WOMEN);

        // ACT
        UserActions.userList.add(user);

        //ASSERT
        assertEquals("Luiz", user.getPersoInfo().getRealName());
        assertEquals(19, (int) user.getPersoInfo().getAge());
        assertEquals("luiz@mail.com", user.getPersoInfo().getEmail());
        assertEquals(ProgLangs.JAVA, user.getProgLangs());
        assertEquals(Gender.MALE, user.getGender());
        assertEquals(Pref.WOMEN, user.getPref());
    }


    @Test
    public void mustListAvailableUsers() {
        //setup

        UserActions userAct = new UserActions();
        User user1 = new ProUser("user", "1234",
                new PersoInfo("User", 25, "user@mail.com"),
                new Address("Rua User", 10, "Userlândia"),
                ProgLangs.RUBY, Gender.MALE, Pref.BOTH, "9999");
        User user2 = new FreeUser("resu", "4321",
                new PersoInfo("Resu", 52, "resu@mail.com"),
                new Address("Rua Resu", 01, "Useraba"),
                ProgLangs.C, Gender.FEMALE, Pref.BOTH);
        UserActions.userList.add(user1);
        UserActions.userList.add(user2);

        //act
        List<User> list =  userAct.listAvailableUsers(user1);
        userAct.showUsers(list);


        //assert
        assertEquals(1, list.size());
        assertEquals("Resu", list.get(0).getPersoInfo().getRealName());
        assertEquals(52, (int) list.get(0).getPersoInfo().getAge());
    }

}


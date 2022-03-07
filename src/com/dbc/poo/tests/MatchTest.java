package com.dbc.poo.tests;

import com.dbc.poo.entities.*;
import com.dbc.poo.enums.Gender;
import com.dbc.poo.enums.Pref;
import com.dbc.poo.enums.ProgLangs;
import org.junit.Test;

public class MatchTest {

    @Test
    public void mustMatch() {
        //Arrange
        User user1 = new ProUser("user", "1234",
                new PersoInfo("User", 25, "user@mail.com"),
                new Address("Rua User", 10, "Userlândia"),
                ProgLangs.RUBY, Gender.MALE, Pref.BOTH, "9999");
        User user2 = new FreeUser("resu", "4321",
                new PersoInfo("Resu", 52, "resu@mail.com"),
                new Address("Rua Resu", 01, "Useraba"),
                ProgLangs.RUBY, Gender.FEMALE, Pref.MEN);
        Match match = new Match();

        //Act
        match.addMatch(user1, user2);

        //Assert
        assert(user1.getMyMatches().contains(user2));
        assert(user2.getMyMatches().contains(user1));

    }
}
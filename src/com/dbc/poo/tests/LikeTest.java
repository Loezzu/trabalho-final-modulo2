package com.dbc.poo.tests;

import com.dbc.poo.entities.*;
import com.dbc.poo.enums.Gender;
import com.dbc.poo.enums.Pref;
import com.dbc.poo.enums.ProgLangs;
import org.junit.Before;
import org.junit.Test;

public class LikeTest {

    private Like likeTest;

    @Before
    public void setUp() {
        likeTest = new Like();
    }

    @Test
    public void mustLikeSomeone() {
        // Arrange
        User user1 = new ProUser("user", "1234",
                new PersoInfo("User", 25, "user@mail.com"),
                new Address("Rua User", 10, "Userlândia"),
                ProgLangs.RUBY, Gender.MALE, Pref.BOTH, "9999");
        User user2 = new FreeUser("resu", "4321",
                new PersoInfo("Resu", 52, "resu@mail.com"),
                new Address("Rua Resu", 01, "Useraba"),
                ProgLangs.RUBY, Gender.FEMALE, Pref.MEN);

        // Act
        likeTest.like(user1, user2);

        // Assert
        assert(user1.getMyLikes().contains(user2));
    }

    @Test
    public void deveDarLikeEntreDuasPessoasEDarMatch() {
        // Arrange
        User user1 = new ProUser("user", "1234",
                new PersoInfo("User", 25, "user@mail.com"),
                new Address("Rua User", 10, "Userlândia"),
                ProgLangs.RUBY, Gender.MALE, Pref.BOTH, "9999");
        User user2 = new FreeUser("resu", "4321",
                new PersoInfo("Resu", 52, "resu@mail.com"),
                new Address("Rua Resu", 01, "Useraba"),
                ProgLangs.RUBY, Gender.FEMALE, Pref.MEN);

        // Act
        likeTest.like(user1, user2);
        likeTest.like(user2, user1);

        // Assert
        assert(user1.getMyLikes().contains(user2));
        assert(user2.getMyLikes().contains(user1));
    }
}
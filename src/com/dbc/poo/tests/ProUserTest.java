package com.dbc.poo.tests;

import com.dbc.poo.entities.Address;
import com.dbc.poo.entities.PersoInfo;
import com.dbc.poo.entities.ProUser;
import com.dbc.poo.entities.User;
import com.dbc.poo.enums.Gender;
import com.dbc.poo.enums.Pref;
import com.dbc.poo.enums.ProgLangs;
import org.junit.Test;

public class ProUserTest {

    @Test
    public void mustPrintProUser() {

        // Arrange
        User user = new ProUser("user", "1234",
                new PersoInfo("User", 25, "user@mail.com"),
                new Address("Rua User", 10, "Userlândia"),
                ProgLangs.RUBY, Gender.MALE, Pref.BOTH, "9999");

        // Act
        user.printMyInfo();


        // Assert
        assert(user.toString().equals("ProUser{username='user', persoInfo=PersoInfo{realName='User', age=25, email='user@mail.com'}, address=Address{street='Rua User', number=10, city='Userlândia'}, progLangs=RUBY, gender=MALE, pref=BOTH, whatsApp=9999}"));
    }
}
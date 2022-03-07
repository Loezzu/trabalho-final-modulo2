package com.dbc.poo.tests;

import com.dbc.poo.entities.*;
import com.dbc.poo.enums.Gender;
import com.dbc.poo.enums.Pref;
import com.dbc.poo.enums.ProgLangs;
import org.junit.Test;

public class UserTest {

    @Test
    public void mustPrintUser() {

        //TESTE DE AMBAS AS CLASSES

        // Arrange
        User userp = new ProUser("user", "1234",
                new PersoInfo("User", 25, "user@mail.com"),
                new Address("Rua User", 10, "Userlândia"),
                ProgLangs.RUBY, Gender.MALE, Pref.BOTH, "9999");
        User userf = new FreeUser("resu", "4321",
                new PersoInfo("Resu", 52, "resu@mail.com"),
                new Address("Rua Resu", 01, "Useraba"),
                ProgLangs.C, Gender.FEMALE, Pref.WOMEN);

        // Act
        userp.printMyInfo();
        userf.printMyInfo();

        // Assert
        assert(userp.toString().equals("ProUser{username='user', persoInfo=PersoInfo{realName='User', age=25, email='user@mail.com'}, address=Address{street='Rua User', number=10, city='Userlândia'}, progLangs=RUBY, gender=MALE, pref=BOTH, whatsApp=9999}"));
        assert(userf.toString().equals("FreeUser{username='resu', persoInfo=PersoInfo{realName='Resu', age=52, email='resu@mail.com'}, address=Address{street='Rua Resu', number=1, city='Useraba'}, progLangs=C, gender=FEMALE, pref=WOMEN}"));

    }
}
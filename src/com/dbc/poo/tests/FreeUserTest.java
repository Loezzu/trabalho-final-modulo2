package com.dbc.poo.tests;

import com.dbc.poo.entities.Address;
import com.dbc.poo.entities.FreeUser;
import com.dbc.poo.entities.PersoInfo;
import com.dbc.poo.entities.User;
import com.dbc.poo.enums.Gender;
import com.dbc.poo.enums.Pref;
import com.dbc.poo.enums.ProgLangs;
import org.junit.Test;

public class FreeUserTest {
    @Test
    public void mustPrintFreeUser() {
        // Arrange
        User user = new FreeUser("resu", "4321",
                new PersoInfo("Resu", 52, "resu@mail.com"),
                new Address("Rua Resu", 01, "Useraba"),
                ProgLangs.C, Gender.FEMALE, Pref.WOMEN);

        // Act
        user.printMyInfo();

        // Assert
        assert(user.toString().equals("FreeUser{username='resu', persoInfo=PersoInfo{realName='Resu', age=52, email='resu@mail.com'}, address=Address{street='Rua Resu', number=1, city='Useraba'}, progLangs=C, gender=FEMALE, pref=WOMEN}"));
    }
}

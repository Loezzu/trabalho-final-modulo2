package com.dbc.poo.tests;

import com.dbc.poo.entities.PersoInfo;
import org.junit.Test;

public class PersoInfoTest {


    @Test
    public void mustPrintPersoInfo() {
        // Arrange
        PersoInfo persoInfo = new PersoInfo("Gabriel", 20, "gabriel@mail.com");


        // Act
        persoInfo.printPersoInfo();

        // Assert
        assert(persoInfo.toString().equals("PersoInfo{realName='Gabriel', age=20, email='gabriel@mail.com'}"));

    }
}
package com.dbc.poo.tests;

import com.dbc.poo.entities.Address;
import org.junit.Test;

public class AddressTest {


    @Test
    public void mustPrintAddress() {
        // Arrange
        Address address = new Address("Rua Gabriel", 264, "Lami");

        // Act
        address.printAddress();

        // Assert
        assert(address.toString().equals("Address{street='Rua Gabriel', number=264, city='Lami'}"));

    }
}
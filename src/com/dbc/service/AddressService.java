package com.dbc.service;


import com.dbc.entities.Address;
import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.repository.AddressRepository;

import java.sql.SQLException;
import java.util.List;

public class AddressService {
    AddressRepository addressRepository = new AddressRepository();

    public void addAddress(Address address){
        try{
            Address newAddress = addressRepository.register(address);
            System.out.println("Address adicionado! " + newAddress);
        } catch (BancoDeDadosException e){
            e.printStackTrace();
        }
    }

    public void listAddress(){
        try{
            List<Address> list = addressRepository.listAll();
            list.forEach(System.out::println);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}

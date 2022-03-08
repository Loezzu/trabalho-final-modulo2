package com.dbc.service;


import com.dbc.entities.Address;
import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.repository.AddressRepository;

public class AddressService {
    AddressRepository addressRepository = new AddressRepository();

    public void addAddress(Address address){
        try{
            Address newAddress = addressRepository.register(address);
            System.out.println("Address adicionado! " + address);
        } catch (BancoDeDadosException e){
            e.printStackTrace();
        }
    }

}

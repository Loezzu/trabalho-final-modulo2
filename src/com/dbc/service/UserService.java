package com.dbc.service;


import com.dbc.entities.User;
import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.repository.UserRepository;

public class UserService {
    UserRepository userRepository = new UserRepository();

    public void addUser(User user){
        try{
            User newUser = userRepository.register(user);
            System.out.println("User adicionado! " + newUser);
        } catch (BancoDeDadosException e){
            e.printStackTrace();
        }
    }

}

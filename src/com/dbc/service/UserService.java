package com.dbc.service;


import com.dbc.entities.PersoInfo;
import com.dbc.entities.User;
import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

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

    public void listUsers(){
        try{
            List<User> list = userRepository.listAll();
            list.forEach(System.out::println);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void removeUserById(Integer id){
        try{
            boolean conseguiuRemover = userRepository.delete(id);
            System.out.println("Conseguiu remover: " + conseguiuRemover + " | ID: " + id);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}

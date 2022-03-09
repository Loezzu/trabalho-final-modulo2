package com.dbc.service;


import com.dbc.model.User;
import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.repository.UserRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserService {
    UserRepository userRepository = new UserRepository();
    LikeService likeService = new LikeService();

    public void addUser(User user){
        try{
            User newUser = userRepository.register(user);
        } catch (BancoDeDadosException e){
            e.printStackTrace();
        }
    }

    public void listUsers(){
        try{
            List<User> list = userRepository.list();
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

    public void editarUsuario(User user, User newUser){
        try{
            boolean conseguiuEditar = userRepository.edit(user, newUser);
            System.out.println("Editou: " + conseguiuEditar);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public List<User> loginList() throws BancoDeDadosException {
        return userRepository.list();
    }

    public void printMyUser(User user){
        System.out.println(user);
    }

    public List<User> listarUsuariosDisponiveis(User user){
        try {
            List<User> availableUsers = new ArrayList<>();
            for (int i = 0; i < loginList().size(); i++) {

                User chosenUser = userRepository.list().get(i);
                if (Objects.equals(chosenUser.getUserId(), user.getUserId()) && Objects.equals(chosenUser.getUserId(), user.getUserId()) && likeService.verificaSeJaFoiDadoLike(user, chosenUser)) {
                    continue;
                }
                if (user.getPref().isCompatible(chosenUser.getGender()) && chosenUser.getPref().isCompatible(user.getGender())) {
                    availableUsers.add(chosenUser);
                }
            }
            return availableUsers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void showUsers(List<User> users)  {
        for (int i=0; i<users.size(); i++) {
            System.out.println(users.get(i));
        }
    }

}

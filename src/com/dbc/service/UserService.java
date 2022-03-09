package com.dbc.service;


import com.dbc.entities.User;
import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.repository.LikeRepository;
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
            System.out.println("User adicionado! " + newUser);
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

    public List<User> loginList() throws BancoDeDadosException {
        return userRepository.list();
    }

    public List<User> listarUsuariosDisponiveis(User user){
        try {
            List<User> availableUsers = new ArrayList<>();
            for (int i = 0; i < loginList().size(); i++) {

                User currentUser = userRepository.list().get(i);

                if (Objects.equals(currentUser.getUserId(), user.getUserId()) && Objects.equals(currentUser.getUserId(), user.getUserId())) {
                    continue;
                }
                //Verifica se o usuário já está na lista de likes do outro usuário
//                if (!likeService.verificaLike(currentUser, user)) {
//                    continue;
//                }

                if (user.getPref().isCompatible(currentUser.getGender()) && currentUser.getPref().isCompatible(user.getGender())) {
                    availableUsers.add(currentUser);
                }
            }
//            List<User> list = userRepository.listarUsuariosDisponiveis(user);
//            list.forEach(System.out::println);
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

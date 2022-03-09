package com.dbc.service;

import com.dbc.entities.Like;
import com.dbc.entities.User;
import com.dbc.repository.LikeRepository;
import com.dbc.repository.UserRepository;

import java.util.List;
import java.util.Scanner;

public class LikeService {

    LikeRepository likeRepository = new LikeRepository();
    UserRepository userRepository = new UserRepository();

    Scanner scan = new Scanner(System.in);


    //imprimir likes de um usuario
    public void printLikes(User user) {
        try {
            List<Like> likes = likeRepository.getLikes(user);
            likes.forEach(System.out::println);
        }catch (Exception e) {
            System.out.println("Não há nenhum like registrado.");
        }

    }


   public void listCandidates(List<User> userList, User user1) {
        boolean itsAMatch = false;
        for (User userChoice : userList) {
            System.out.println("\n" + userChoice);
            System.out.println("\n Deseja dar like? (s/n)");
            String choice = scan.nextLine();
            if (choice.equalsIgnoreCase("s") || choice.equalsIgnoreCase("sim")) {
                itsAMatch = darLike(new Like(), user1, userChoice.getUsername());
            }
        }
       System.out.println("\n Não há mais nenhum usuário disponível para dar like.");
    }


    public boolean darLike(Like like, User user, String username) {
            try {
                Like conseguiuDarLike = likeRepository.register(like, user, username);
                return true;
            } catch (Exception e) {
                System.out.println("Não foi possível dar like.");
                return false;
            }
        }


}

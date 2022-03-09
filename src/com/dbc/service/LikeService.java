package com.dbc.service;

import com.dbc.model.Like;
import com.dbc.model.User;
import com.dbc.repository.LikeRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class LikeService {

    LikeRepository likeRepository = new LikeRepository();
    Scanner scan = new Scanner(System.in);


    //imprimir likes de um usuario
    public void printLikes(Integer id) {
        try {
            List<Like> likes = likeRepository.getLikes(id);
            likes.forEach(System.out::println);
        }catch (Exception e) {
            System.out.println("Não há nenhum like registrado.");
        }

    }


   public void listCandidates(List<User> userList, User user1) {
        for (User userChoice : userList) {
            System.out.println("\n" + userChoice);
            System.out.println("\n Deseja dar like? (s/n)");
            String choice = scan.nextLine();
            if (choice.equalsIgnoreCase("s") || choice.equalsIgnoreCase("sim")) {
                darLike(new Like(), user1, userChoice.getUsername());
                match(user1, userChoice);
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

   public void match(User user1, User user2) {
        try {
            if (user1.getProgLangs().equals(user2.getProgLangs())) {
                System.out.println("\n" + user1 + " e " + user2 + " formaram um casal.");
            } else {
                System.out.println("\n" + user1 + " e " + user2 + " não formaram um casal.");
            }
        } catch (Exception e) {
            System.out.println("Não há nenhum match registrado.");
        }
   }


    public boolean verificaSeJaFoiDadoLike(User user, User currentUser) {
        try {
            List<Like> likes = likeRepository.getLikes(user.getUserId());
            for (Like like : likes) {
                if (like.getUsername().equals(currentUser.getUsername())) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Não há nenhum like registrado.");
        }
        return false;
    }

    public void deleteLikeById(int id) {
        try{
            likeRepository.delete(id);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

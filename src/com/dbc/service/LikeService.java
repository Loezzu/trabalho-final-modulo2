package com.dbc.service;

import com.dbc.entities.Like;
import com.dbc.entities.User;
import com.dbc.repository.LikeRepository;

public class LikeService {

    LikeRepository likeRepository = new LikeRepository();

//        public void darLike(User user1, User user2) {
//        if (user1.equals(user2)) {
//            System.out.println("Não é possível dar like em você.");
//        } else {
//            user1.getMyLikes().add(user2);
//        }
//        if(user2.getMyLikes().contains(user1) && user1.getMyLikes().contains(user2)) {
//            System.out.println("Podemos ter um casal, pois "+user1.getPersoInfo().getRealName()+" e "+user2.getPersoInfo().getRealName()+" trocaram likes!" +
//                    "\nEstamos analisando um possível match...");
//        }
//        try {
//            boolean conseguiuDarLike = likeRepository.register();
//        } catch (Exception e) {
//            System.out.println("Não foi possível dar like.");
//        }
//    }

    public void darLike(Like like, User user, String username) {
            try {
                Like conseguiuDarLike = likeRepository.register(like, user, username);
            } catch (Exception e) {
                System.out.println("Não foi possível dar like.");
            }
        }


}

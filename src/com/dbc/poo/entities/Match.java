package com.dbc.poo.entities;

import com.dbc.poo.entities.User;

public class Match {
    public void addMatch(User user1, User user2) {
        if (user1.getProgLangs().equals(user2.getProgLangs())) {
            user1.getMyMatches().add(user2);
            user2.getMyMatches().add(user1);
            System.out.println("DEU MATCH POIS A LINGUAGEM DE PROGRAMAÇÃO É COMPATÍVEL.");
        } else {
            System.out.println("INFELIZMENTE NÃO DEU MATCH POIS A LINGUAGEM DE PROGRAMAÇÃO É INCOMPATÍVEL.");
        }
    }
}

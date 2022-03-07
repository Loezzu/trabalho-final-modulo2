package com.dbc.poo.interfaces;

import com.dbc.poo.entities.User;

import java.util.List;

public interface Actions {
        void registerUser();
        void listAllUsers();
        void updateUser(User user);
        void deleteUser(User user);
        List<User> listAvailableUsers(User user);
        void showUsers(List<User> users);
}

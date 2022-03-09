package com.dbc.model;

public class Like {

    private int id_like;
    private int user_id;
    private String username;


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId_like() {
        return id_like;
    }

    public void setId_like(int id_like) {
        this.id_like = id_like;
    }

    @Override
    public String toString() {
        return "Like{" +
                "id_like=" + id_like +
                ", user_id=" + user_id +
                ", username='" + username + '\'' +
                '}';
    }
}

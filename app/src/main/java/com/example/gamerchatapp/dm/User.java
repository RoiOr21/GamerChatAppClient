package com.example.gamerchatapp.dm;

import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private String email;
    private String salt;
    private String password;
    private ArrayList<User> friends;
    private ArrayList<Game> favGames;

    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public User(String name, String email, String password, String salt) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.friends = new ArrayList<User>();
        this.favGames = new ArrayList<Game>();
    }

    public User(int id, String name, String email, String salt, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salt = salt;
        this.password = password;
        this.friends = new ArrayList<User>();
        this.favGames = new ArrayList<Game>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<User> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<User> friends) {
        this.friends = friends;
    }

    public ArrayList<Game> getFavGames() {
        return favGames;
    }

    public void setFavGames(ArrayList<Game> favGames) {
        this.favGames = favGames;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", salt='" + salt + '\'' +
                ", password='" + password + '\'' +
                ", friends=" + friends +
                ", favGames=" + favGames +
                '}';
    }
}

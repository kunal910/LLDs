package com.animator.catalog.splitwise.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private List<User> userList = new ArrayList<>();

    public void addUser(User user){
        userList.add(user);
    }

    public User getUser(int userID) {
        for (User user : userList) {
            if (user.getId() == userID) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers(){
        return userList;
    }


}

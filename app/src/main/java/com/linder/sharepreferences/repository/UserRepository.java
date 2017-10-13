package com.linder.sharepreferences.repository;

import com.linder.sharepreferences.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linderhassinger on 10/9/17.
 */

public class UserRepository {
    public static List<User> users = new ArrayList<>();

    static{
        users.add(new User(100, "lhassinger", "tecsup", "Linder Hassinger"));
        users.add(new User(200, "c jermias", "tecsup", "Carolina Jeremias"));
        users.add(new User(300, "khanz", "tecsup", "Keving Hanz"));
    }

    public static User addUser( String username, String password, String fullname){
        for ( int i = 400; i< 99999; i+=100){
            users.add(new User(i, username, password, fullname));

        }
        return login(username, password);

    }

    public static User login(String username, String password){
        for (User user : users){
            if(user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public static User getUser(String username){
        for (User user : users){
            if(user.getUsername().equalsIgnoreCase(username)){
                return user;
            }
        }
        return null;
    }

}


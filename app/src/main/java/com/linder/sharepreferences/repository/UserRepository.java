package com.linder.sharepreferences.repository;

import android.util.Log;

import com.linder.sharepreferences.model.User;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linderhassinger on 10/9/17.
 */

public class UserRepository {

    public static List<User> list() {
        List<User> users = SugarRecord.listAll(User.class);
        return users;
    }

    public static User read(Long id) {
        User user = SugarRecord.findById(User.class, id);
        return user;
    }

    public static User login(String username, String password){
        List<User> users = SugarRecord.listAll(User.class);
        Log.d("username", username);
        Log.d("pwd", password);
        Log.d("USERS", "" +users);


        for (User user : users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){

                return user;
            }
        }
        return null;
    }


    public static void create(String username, String password, String fullname) {
        User user = new User(username, password, fullname);

        SugarRecord.save(user);
    }

    public static void update(String fullname, String email, String password, Long id) {
        User user = SugarRecord.findById(User.class, id);
        user.setFullname(fullname);
        user.setPassword(password);
        SugarRecord.save(user);
    }

    public static void delete(Long id) {
        User user = SugarRecord.findById(User.class, id);
        SugarRecord.delete(user);
    }


}

   /* public static User addUser( String username, String password, String fullname){
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

}*/


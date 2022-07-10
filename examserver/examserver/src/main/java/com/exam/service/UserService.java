package com.exam.service;

import com.exam.model.User;
import com.exam.model.UserRole;

import java.util.Set;

public interface UserService {

    public User createUser(User user, Set<UserRole> userRoles) throws Exception;


    //getusername by username
    public User getUser(String username);


    //delete user by id
    public void deleteUser(long id);



}

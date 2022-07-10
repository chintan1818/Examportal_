package com.exam.controller;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    //creating user
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {

        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

        Role role = new Role();
        role.setRoleId(1);
        role.setRoleName("ADMIN");

        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);

        Set<UserRole> setUserRole = new HashSet<>();
        setUserRole.add(userRole);
        user.setUserRoles(setUserRole);

        return this.userService.createUser(user,setUserRole);



    }


    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username)
    {
        return  userService.getUser(username);
    }


    @DeleteMapping ("/{id}")
    public void getUser(@PathVariable("id") long id)
    {
          userService.deleteUser(id);
    }
}

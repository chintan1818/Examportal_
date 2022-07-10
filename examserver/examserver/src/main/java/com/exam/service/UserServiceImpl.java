package com.exam.service;

import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Set;

@Service
@CrossOrigin("*")
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

         User local= this.userRepository.findByUserName(user.getUserName());

        {
            if (local!=null) {
                System.out.println("user is already there");
                System.out.println(local);
                throw new Exception("user already present");
            } else {

                for (UserRole ur : userRoles
                ) {
                    System.out.println(ur.getRole());
                    roleRepository.save(ur.getRole());

                }

                user.getUserRoles().addAll(userRoles);
                userRepository.save(user);


            }
        }

        return user;

    }

    //get user by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUserName(username);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }


}

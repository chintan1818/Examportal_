package com.exam.service;

import com.exam.model.User;
import com.exam.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            System.out.println("loadUserByUsername"+username);
        User user = this.userRepository.findByUserName(username);
        if(user==null)
        {
            System.out.println("user not found");
            throw new UsernameNotFoundException("no username found");
        }

        return user;

        //return new User("rfef","aaa",new ArrayList<>());
    }
}

package com.delibot.service;

import com.delibot.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    public User saveUser( User user) ;

    public List<User> findAll();

    public UserDetails loadUserByUsername(String username);

}

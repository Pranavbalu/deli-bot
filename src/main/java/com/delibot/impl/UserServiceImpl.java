package com.delibot.impl;

import com.delibot.domain.CustomUserDetails;
import com.delibot.domain.User;
import com.delibot.repository.UserRepository;
import com.delibot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;

    public User saveUser( User user) {
        return userRepo.save(user);
    }

    public List<User> findAll( ) {
      return (List<User>) userRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }


}

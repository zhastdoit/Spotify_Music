package com.hellokoding.account.service;

import com.hellokoding.account.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

public class FindUsername {

    public static String findLoggedInUsername() {
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user != null) {
            return user.getUsername();
        }
        return null;
    }

}

package com.hellokoding.account.repository;

import org.springframework.security.core.context.SecurityContextHolder;

public interface FindUsername {
    default String findLoggedInUsername() {
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user != null) {
            return user.getUsername();
        }
        return null;
    }
}

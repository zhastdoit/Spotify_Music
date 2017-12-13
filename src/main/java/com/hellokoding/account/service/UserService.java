package com.hellokoding.account.service;

import com.hellokoding.account.model.Follow;
import com.hellokoding.account.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User findById(Long id);
    User findByUsername(String username);

    List<User> getFollowersById(Long uid);
    List<User> getFollowingsById(Long uid);
}

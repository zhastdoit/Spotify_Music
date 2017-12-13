package com.hellokoding.account.service;

import com.hellokoding.account.model.Follow;
import com.hellokoding.account.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    void saveFollow(Long uid, Long fid);
    void saveLike(Long uid, Long aid);
    void deleteFollow(Long uid, Long fid);
    void deleteLike(Long uid, Long aid);

    User findById(Long id);
    User findByUsername(String username);

    List<User> getFollowersById(Long uid);
    List<User> getFollowingsById(Long uid);
    boolean isFollowing(Long uid, Long fid);

    List<User> getFansById(Long aid);
    boolean isLiking(Long uid, Long aid);
}

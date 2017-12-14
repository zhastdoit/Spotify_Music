package com.hellokoding.account.service;

import com.hellokoding.account.model.Follow;
import com.hellokoding.account.model.Like;
import com.hellokoding.account.model.User;
import com.hellokoding.account.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private FollowRepository followRepository;
    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setUsername(user.getUsername());
        user.setEmail(user.getEmail());
        user.setCity(user.getCity());
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public void saveFollow(Long uid, Long fid) {
        Follow follow = new Follow(uid, fid);
        followRepository.save(follow);
    }

    @Override
    public void deleteFollow(Long uid, Long fid) {
        Follow followToDelete = followRepository.getByUidAndFid(uid, fid);
        followRepository.delete(followToDelete);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getFollowersById(Long uid){
        List<Follow> followersRecord = followRepository.getAllByFid(uid);
        List<User> followers = new ArrayList<>();
        for(Follow follow : followersRecord) {
            followers.add(findById(follow.getUid()));
        }
        return followers;
    }

    @Override
    public List<User> getFollowingsById(Long uid){
        List<Follow> followingsRecord = followRepository.findFollowings(uid);
        List<User> followings = new ArrayList<>();
        for(Follow follow : followingsRecord) {
            followings.add(findById(follow.getFid()));
        }
        return followings;
    }

    @Override
    public boolean isFollowing(Long uid, Long fid) {
        if(followRepository.getByUidAndFid(uid, fid) != null){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void saveLike(Long uid, Long aid){
        Like like = new Like(uid,aid);
        likeRepository.save(like);
    }

    @Override
    public void deleteLike(Long uid, Long aid){
        Like likeToDelete = likeRepository.getByUidAndAid(uid, aid);
        likeRepository.delete(likeToDelete);
    }

    @Override
    public List<User> getFansById(Long aid) {
        List<Like> likesRecord = likeRepository.getAllByAid(aid);
        List<User> fans = new ArrayList<>();
        for(Like like : likesRecord) {
            fans.add(findById(like.getUid()));
        }
        return fans;
    }

    @Override
    public boolean isLiking(Long uid, Long aid) {
        if(likeRepository.getByUidAndAid(uid, aid) != null){
            return true;
        } else {
            return false;
        }
    }
}

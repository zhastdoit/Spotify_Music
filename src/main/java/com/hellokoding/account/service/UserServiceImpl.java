package com.hellokoding.account.service;

import com.hellokoding.account.model.Follow;
import com.hellokoding.account.model.User;
import com.hellokoding.account.repository.FollowRepository;
import com.hellokoding.account.repository.RoleRepository;
import com.hellokoding.account.repository.UserRepository;
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

}

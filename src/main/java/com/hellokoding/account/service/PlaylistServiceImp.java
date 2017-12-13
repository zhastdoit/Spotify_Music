package com.hellokoding.account.service;

import com.hellokoding.account.model.Playlist;
import com.hellokoding.account.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.OneToMany;
import java.util.List;

@Service
public class PlaylistServiceImp implements PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Override
    public List<Playlist> getUserPlaylist(Long uid) {
        return playlistRepository.getPlaylists(uid);
    }

}

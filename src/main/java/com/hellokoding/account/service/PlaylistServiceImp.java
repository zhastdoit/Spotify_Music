package com.hellokoding.account.service;

import com.hellokoding.account.model.Playlist;
import com.hellokoding.account.model.User;
import com.hellokoding.account.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.OneToMany;
import java.util.List;

@Service
public class PlaylistServiceImp implements PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private UserService userService;

    @Override
    public List<Playlist> getUserPlaylist(Long uid) {
        return playlistRepository.getPlaylists(uid);
    }

    @Override
    public void savePlaylist(Playlist playlist) {
        playlistRepository.save(playlist);
    }

    @Override
    public Playlist getPlaylistWithPid(Long pid) {
        return playlistRepository.getPlaylistsByPid(pid);
    }
}

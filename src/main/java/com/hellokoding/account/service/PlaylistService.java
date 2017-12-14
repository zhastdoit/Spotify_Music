package com.hellokoding.account.service;

import com.hellokoding.account.model.Playlist;

import java.util.List;

public interface PlaylistService {
    List<Playlist> getUserPlaylist(Long uid);
    void savePlaylist(Playlist playlist);
    Playlist getPlaylistWithPid(Long pid);
}

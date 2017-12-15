package com.hellokoding.account.service;

import com.hellokoding.account.model.Playlist;
import com.hellokoding.account.model.TrackInPlaylist;

import java.util.List;

public interface PlaylistService {
    List<Playlist> getUserPlaylist(Long uid);
    void savePlaylist(Playlist playlist);
    Playlist getPlaylistWithPid(Long pid);
    void saveTrackInPlaylist(TrackInPlaylist obj);
    void removeTrackInPlaylist(Long pid, Long tid);
    void removePlaylist(Long pid);
}

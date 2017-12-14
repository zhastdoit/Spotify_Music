package com.hellokoding.account.service;

import com.hellokoding.account.model.Listen;
import com.hellokoding.account.model.Rate;
import com.hellokoding.account.model.Track;

import java.util.List;
import java.util.Optional;

public interface TrackService {
    Track findById(Long id);
    void saveRate(Rate rate);
    void saveListen(Long uid, Long tid);
    List<Rate> getMyRate(Long uid);
    Optional<Double> getAverageScore(Long tid);
    List<Track> getTrackList();
    List<Track> getTrackByPlaylist(Long pid);
    List<Track> getTrackByAlbum(Long alid);
    List<Listen> getListenByUserID(Long uid);
    List<Track> recommendByRecentListen(Long uid);
}

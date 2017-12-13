package com.hellokoding.account.service;

import com.hellokoding.account.model.Rate;
import com.hellokoding.account.model.Track;

import java.util.List;
import java.util.Optional;

public interface TrackService {
    Track findById(Long id);
    void saveRate(Rate rate);
    List<Rate> getMyRate(Long uid);
    Optional<Double> getAverageScore(Long tid);
    List<Track> getTrackList();
    List<Track> getTrackByPlaylist(Long pid);
}

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
    @Deprecated
    List<Track> getTrackList();
    List<Track> obtainTracksByIdRangeFrom(Long a, Long b);
    List<Track> getTrackByPlaylist(Long pid);
    List<Track> getTrackByAlbum(Long alid);
    List<Listen> getListenByUserID(Long uid);
    List<Track> recommendByRecentListen(Long uid);
    List<Track> getListenedTracksByUid(Long uid);
    List<Track> getTrackByKeyword(String keyword);
    List<Track> getTracksByGenreKeyword(String genre);
    List<Track> getFollowingsListenTracksByUid(Long uid);
}

package com.hellokoding.account.service;

import com.hellokoding.account.model.*;
import com.hellokoding.account.repository.*;
import com.hellokoding.account.repository.AlbumRepository;
import com.hellokoding.account.repository.PlaylistRepository;
import com.hellokoding.account.repository.RateRepository;
import com.hellokoding.account.repository.TrackRepository;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImp implements TrackService {

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RateRepository rateRepository;

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private ListenRepository listenRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private FollowRepository followRepository;

    @Override
    public Track findById(Long id) {
        return trackRepository.findById(id);
    }

    @Override
    public List<Track> getTrackList() {
        return trackRepository.findAll();
    }

    @Override
    public List<Track> obtainTracksByIdRangeFrom(Long a, Long b){
        Long total = trackRepository.count();
        List<Track> trackList = new ArrayList<>();
        if(a.compareTo(total) > 0 || a.compareTo(b) > 0) {
            return trackList;
        } else {
            trackList = trackRepository.getTracksByIdBetween(a, b);
        }
        return trackList;
    }

    @Override
    public void saveRate(Rate rate) {
        rateRepository.save(rate);
    }

    @Override
    public List<Rate> getMyRate(Long uid) {
        return rateRepository.findMyRate(uid);
    }

    @Override
    public Optional<Double> getAverageScore(Long tid) {
        return rateRepository.getAverageScore(tid);
    }

    @Override
    public List<Track> getTrackByPlaylist(Long pid) {
        return playlistRepository.getTrackByPlaylistId(pid);
    }

    @Override
    public void saveListen(Long uid, Long tid) {
        Listen listen = new Listen(uid,tid);
        listenRepository.save(listen);
    }

    @Override
    public List<Listen> getListenByUserID(Long uid) {
        return listenRepository.getAllByUid(uid);
    }

    @Override
    public List<Track> recommendByRecentListen (Long uid) {
        //List<Listen> listenHistory = getListenByUserID(uid);
        List<Track> recommendation = new ArrayList<>();
        List<Listen> mostRecentListen = listenRepository.getTop3ByUidOrderByTimestampDesc(uid);
        if(mostRecentListen == null) {
            recommendation.addAll(trackRepository.getTop10ByArtist(artistRepository.getArtistFromId(1L)));
            return recommendation;
        }
        mostRecentListen.stream().forEach(listen -> {
            Artist mostRecentArtist = trackRepository.findById(listen.getTid()).getArtist();
            recommendation.addAll(trackRepository.getTop3ByArtist(mostRecentArtist));
        });
        if(mostRecentListen!=null && mostRecentListen.size()>1){
            recommendation.add(trackRepository.findById(mostRecentListen.get(0).getTid()));
        }

        return recommendation;
    }

    @Override
    public List<Track> getTrackByAlbum(Long alid) {
        return albumRepository.getTrackByAlbumId(alid);
    }

    @Override
    public List<Track> getTrackByKeyword(String keyword) {
        return trackRepository.getTop10TracksByTtitleContains(keyword);
    }

    @Override
    public List<Track> getTracksByGenreKeyword(String genre) {
        return trackRepository.getTop10TracksByGenreContains(genre);
    }

    @Override
    public List<Track> getListenedTracksByUid(Long uid) {
        List<Listen> listenHistory = listenRepository.getTop10ByUidOrderByTimestampDesc(uid);
        List<Track> tracks = new ArrayList<>();
        listenHistory.stream().forEach(l -> tracks.add(trackRepository.findById(l.getTid())));
        return tracks;
    }

    @Override
    public List<Track> getFollowingsListenTracksByUid(Long uid) {
        List<Follow> followings = followRepository.getTop5ByUidOrderByTimestampDesc(uid);
        List<Track> tracks = new ArrayList<>();
        followings.stream().forEach(f -> {
            List<Track> list = getListenedTracksByUid(f.getUid());
            if (list.size() > 2) {
                tracks.add(list.get(0));
                tracks.add(list.get(1));
            }
        });
        return tracks;
    }
}

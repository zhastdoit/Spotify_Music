package com.hellokoding.account.service;

import com.hellokoding.account.model.Artist;
import com.hellokoding.account.model.Listen;
import com.hellokoding.account.model.Rate;
import com.hellokoding.account.model.Track;
import com.hellokoding.account.repository.*;
import com.hellokoding.account.repository.AlbumRepository;
import com.hellokoding.account.repository.PlaylistRepository;
import com.hellokoding.account.repository.RateRepository;
import com.hellokoding.account.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImp implements TrackService {

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private RateRepository rateRepository;

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private ListenRepository listenRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistRepository artistRepository;

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
        Listen mostRecentListen = listenRepository.getTopByTidOrderByTimestampDesc(uid);
        if(mostRecentListen == null) {
            recommendation.add(trackRepository.findById(1L));
            return recommendation;
        }
        Artist mostRecentArtist = trackRepository.findById(mostRecentListen.getTid()).getArtist();
        List<Track> trackList = trackRepository.getAllByArtist(mostRecentArtist);
        int counter = 0;
        for (Track t : trackList) {
            recommendation.add(t);
            counter++;
            if (counter>=5) {
                break;
            }
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


}

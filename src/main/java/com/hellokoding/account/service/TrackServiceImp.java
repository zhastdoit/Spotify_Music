package com.hellokoding.account.service;

import com.hellokoding.account.model.Rate;
import com.hellokoding.account.model.Track;
import com.hellokoding.account.repository.PlaylistRepository;
import com.hellokoding.account.repository.RateRepository;
import com.hellokoding.account.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.OneToMany;
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

    @Override
    public Track findById(Long id) {
        return trackRepository.findById(id);
    }

    @Override
    public List<Track> getTrackList() {
        return trackRepository.findAll();
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
}

package com.hellokoding.account.service;

import com.hellokoding.account.model.Artist;
import com.hellokoding.account.model.Track;
import com.hellokoding.account.repository.ArtistRepository;
import com.hellokoding.account.repository.TrackArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImp implements ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private TrackArtistRepository trackArtistRepository;

    @Override
    public List<Artist> getArtistList() {
        return artistRepository.findAll();
    }

    @Override
    public List<Track> getArtistTrackList(String artistName) {
        return trackArtistRepository.getTheArtistTrack(artistName);

    }
    @Override
    public Artist getArtistById(Long id) {
        return artistRepository.getArtistFromId(id);
    }

}

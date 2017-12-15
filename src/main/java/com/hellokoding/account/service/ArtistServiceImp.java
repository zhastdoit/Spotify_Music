package com.hellokoding.account.service;

import com.hellokoding.account.model.Artist;
import com.hellokoding.account.model.Like;
import com.hellokoding.account.model.Track;
import com.hellokoding.account.repository.ArtistRepository;
import com.hellokoding.account.repository.LikeRepository;
import com.hellokoding.account.repository.TrackArtistRepository;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistServiceImp implements ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private TrackArtistRepository trackArtistRepository;

    @Autowired
    private LikeRepository likeRepository;

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

    @Override
    public List<Artist> obtainArtistsByIdRangeFrom(Long a, Long b) {
        return artistRepository.getArtistByIdBetween(a, b);
    }
    @Override
    public List<Artist> getArtistByKeyword(String keyword) {
        return artistRepository.getTop10ArtistsByAnameContains(keyword);
    }
    @Override
    public List<Artist> getFavoriteArtistsByUid(Long uid) {
        List<Like> likes = likeRepository.getAllByUid(uid);
        List<Artist> artists = new ArrayList<>();
        likes.stream().forEach(like -> artists.add(getArtistById(like.getAid())));
        return artists;
    }
}

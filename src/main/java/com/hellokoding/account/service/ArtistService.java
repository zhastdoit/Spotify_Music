package com.hellokoding.account.service;

import com.hellokoding.account.model.Artist;
import com.hellokoding.account.model.Track;

import java.util.List;


public interface ArtistService {

    List<Artist> getArtistList();
    Artist getArtistById(Long id);
    List<Track> getArtistTrackList(String artistName);
    List<Artist> obtainArtistsByIdRangeFrom(Long a, Long b);
    List<Artist> getArtistByKeyword(String keyword);
    List<Artist> getFavoriteArtistsByUid(Long uid);
}

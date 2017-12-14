package com.hellokoding.account.repository;

import com.hellokoding.account.model.Artist;
import com.hellokoding.account.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Long> {
    Track findById(Long id);
    List<Track> getAllByArtist(Artist artist);
}

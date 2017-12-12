package com.hellokoding.account.repository;

import com.hellokoding.account.model.Artist;
import com.hellokoding.account.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrackArtistRepository extends JpaRepository<Track, Long>{
    @Query("select T from Track T join T.artist A where A.aname = :artistName")
    List<Track> getTheArtistTrack(@Param("artistName") String artistName);
}

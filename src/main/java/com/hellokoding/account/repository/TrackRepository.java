package com.hellokoding.account.repository;

import com.hellokoding.account.model.Artist;
import com.hellokoding.account.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Long> {
    Track findById(Long id);
    List<Track> getTop10ByArtist(Artist artist);
    Long countAllByArtist(Artist artist);
    List<Track> getTracksByIdBetween(Long a, Long b);
//    @Query("SELECT Track From Track T where T.id > :a AND T.id <= :b")
//    List<Track> obtainTracksRangeFrom(@Param("a") Long a, @Param("b") Long b);
    List<Track> getTop3ByArtist(Artist artist);
    List<Track> getTop10TracksByTtitleContains(String keyword);
    List<Track> getTop10TracksByGenreContains(String genre);

}

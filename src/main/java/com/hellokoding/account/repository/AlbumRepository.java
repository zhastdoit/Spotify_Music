package com.hellokoding.account.repository;

import com.hellokoding.account.model.Album;
import com.hellokoding.account.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    @Query("select A.trackList from Album A where A.alid = :alid")
    List<Track> getTrackByAlbumId(@Param("alid") Long alid);

    List<Album> getTop10AlbumsByAtitleContains(String keyword);

    List<Album> getAllByAlidBetween(Long a, Long b);

    Album getAlbumByAlid(Long alid);
}

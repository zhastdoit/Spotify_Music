package com.hellokoding.account.repository;

import com.hellokoding.account.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    @Query("select P from Playlist P where P.owner.id = :uid")
    List<Playlist> getPlaylists(@Param("uid") Long uid);
}

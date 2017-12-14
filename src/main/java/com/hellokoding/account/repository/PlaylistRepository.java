package com.hellokoding.account.repository;

import com.hellokoding.account.model.Playlist;
import com.hellokoding.account.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    @Query("select P from Playlist P where P.uid = :uid")
    List<Playlist> getPlaylists(@Param("uid") Long uid);

    @Query("select P.trackList from Playlist P where P.pid = :pid")
    List<Track> getTrackByPlaylistId(@Param("pid")Long pid);

    Playlist getPlaylistsByPid(Long pid);
}

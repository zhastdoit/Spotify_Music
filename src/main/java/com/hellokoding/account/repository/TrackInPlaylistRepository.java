package com.hellokoding.account.repository;

import com.hellokoding.account.model.Album;
import com.hellokoding.account.model.Track;
import com.hellokoding.account.model.TrackInPlaylist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrackInPlaylistRepository extends JpaRepository<TrackInPlaylist, Long> {
    TrackInPlaylist getByPidAndTid(Long pid, Long tid);
}

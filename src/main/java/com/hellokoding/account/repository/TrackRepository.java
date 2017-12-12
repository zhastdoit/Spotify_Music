package com.hellokoding.account.repository;

import com.hellokoding.account.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track, Long> {
    Track findById(Long id);
}

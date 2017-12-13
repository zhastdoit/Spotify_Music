package com.hellokoding.account.repository;

import com.hellokoding.account.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {

}

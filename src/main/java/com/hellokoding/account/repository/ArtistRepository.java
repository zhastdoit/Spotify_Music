package com.hellokoding.account.repository;

import com.hellokoding.account.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    @Query("select A from Artist A where A.id = :artistid")
    Artist getArtistFromId(@Param("artistid") Long id);
    List<Artist> getArtistByIdBetween(Long a, Long b);

    List<Artist> getTop10ArtistsByAnameContains(String keyword);

}

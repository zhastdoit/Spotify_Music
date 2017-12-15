package com.hellokoding.account.repository;

import com.hellokoding.account.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Long> {

    List<Follow> getAllByFid(Long id);

    Follow getByUidAndFid(Long uid, Long fid);

    @Query("select F from Follow F where F.uid = :userId")
    List<Follow> findFollowings(@Param("userId") Long uid);

    List<Follow> getTop5ByUidOrderByTimestampDesc(Long uid);
}

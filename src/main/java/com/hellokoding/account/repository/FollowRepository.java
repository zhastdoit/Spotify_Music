package com.hellokoding.account.repository;

import com.hellokoding.account.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    List<Follow> getAllByFid(Long id);

//    List<Follow> getAllByUid(Long id);

    @Query("select F from Follow F where F.uid = :userId")
    List<Follow> findFollowings(@Param("userId") Long uid);

//    @Query("select User from Follow F join User U where F.fid =  ")
//    List<User>
}

package com.hellokoding.account.repository;

import com.hellokoding.account.model.Follow;
import com.hellokoding.account.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {

    List<Like> getAllByAid(Long id);

    List<Like> getAllByUid(Long id);

    Long countAllByAid(Long id);

    Like getByUidAndAid(Long uid, Long fid);

}

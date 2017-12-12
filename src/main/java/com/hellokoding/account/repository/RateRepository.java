package com.hellokoding.account.repository;

import com.hellokoding.account.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RateRepository extends JpaRepository<Rate, Long> {
    @Query("select R from Rate R where R.uid = :userId")
    List<Rate> findMyRate(@Param("userId") Long uid);
}

package com.hellokoding.account.repository;

import com.hellokoding.account.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RateRepository extends JpaRepository<Rate, Long> {
    @Query("select R from Rate R where R.uid = :userId")
    List<Rate> findMyRate(@Param("userId") Long uid);

    @Query("select avg(R.score) as score from Rate R where R.tid = :tid ")
    Optional<Double> getAverageScore(@Param("tid") Long tid);


}

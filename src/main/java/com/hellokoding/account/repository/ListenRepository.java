package com.hellokoding.account.repository;

import com.hellokoding.account.model.Like;
import com.hellokoding.account.model.Listen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ListenRepository extends JpaRepository<Listen, Long> {

    List<Listen> getAllByUid(Long id);

    Long countAllByUid(Long id);

    Listen getByUidAndTid(Long uid, Long tid);

    Listen countListenByTid(Long tid);

    Listen getTopByTidOrderByTimestampDesc(Long tid);
}

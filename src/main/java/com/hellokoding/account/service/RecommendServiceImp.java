package com.hellokoding.account.service;

import com.hellokoding.account.model.Rate;
import com.hellokoding.account.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RecommendServiceImp implements RecommendService {

    @Autowired
    private RateRepository rateRepository;

    @Override
    public List<Long> getRecommendTrack() {
        List<Rate> listRate = rateRepository.findAll();
        Collections.sort(listRate, (rate1, rate2) -> rate2.getScore() - rate1.getScore());
        List<Long> recommendTrack = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            recommendTrack.add(listRate.get(i).getTid());
        }
        return recommendTrack;
    }
}

package com.hellokoding.account.service;

import com.hellokoding.account.model.Rate;
import com.hellokoding.account.model.Track;
import com.hellokoding.account.repository.RateRepository;
import com.hellokoding.account.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackServiceImp implements TrackService {

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private RateRepository rateRepository;

    @Override
    public Track findById(Long id) {
        return trackRepository.findById(id);
    }

    @Override
    public void saveRate(Rate rate) {
        rateRepository.save(rate);
    }
}

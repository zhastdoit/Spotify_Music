package com.hellokoding.account.service;

import com.hellokoding.account.model.Rate;
import com.hellokoding.account.model.Track;

public interface TrackService {
    Track findById(Long id);
    void saveRate(Rate rate);
}

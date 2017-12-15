package com.hellokoding.account.service;

import com.hellokoding.account.model.Rate;
import com.hellokoding.account.model.Track;

import java.util.List;

public interface RecommendService {
    List<Long> getRecommendTrack();
}

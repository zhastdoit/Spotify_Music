package com.hellokoding.account.web;

import com.hellokoding.account.model.Artist;
import com.hellokoding.account.model.Rate;
import com.hellokoding.account.model.Track;
import com.hellokoding.account.model.User;
import com.hellokoding.account.service.FindUsername;
import com.hellokoding.account.service.TrackService;
import com.hellokoding.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/track")
public class TrackController {

    private final int ITEM_PER_PAGE = 15;

    @Autowired
    private TrackService trackService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/all"}, method = RequestMethod.GET)
    public String showAllTrack(Model theModel) {
        List<Track> allTrack = trackService.obtainTracksByIdRangeFrom(Long.valueOf(0),Long.valueOf(ITEM_PER_PAGE-1));
        List<Double> scores = new ArrayList<>();
        allTrack.forEach((track) -> {
            Long tid = track.getId();
            scores.add(trackService.getAverageScore(tid).isPresent() ? trackService.getAverageScore(tid).get() :(Double) 0d);
        });
        theModel.addAttribute("notFirstPage", false);
        theModel.addAttribute("fromIndex", 0);
        theModel.addAttribute("trackList", allTrack);
        theModel.addAttribute("scores", scores);
        return "tracks";
    }

    @RequestMapping(value = {"/all"}, method = RequestMethod.POST)
    public String showTracksInRange(@RequestParam("next") String next, @RequestParam("fromIndex") String fromIndex, Model theModel) {
        int currentFrom = Integer.parseInt(fromIndex);
        boolean isNext = Boolean.parseBoolean(next);
        List<Track> allTrackInRange = new ArrayList<>();
        if(isNext) {
            allTrackInRange = trackService.obtainTracksByIdRangeFrom(Long.valueOf(currentFrom+ITEM_PER_PAGE),Long.valueOf(currentFrom+ITEM_PER_PAGE*2)-1);
            currentFrom = currentFrom+ITEM_PER_PAGE;
        } else {
            allTrackInRange = trackService.obtainTracksByIdRangeFrom(Long.valueOf(currentFrom-ITEM_PER_PAGE),Long.valueOf(currentFrom)-1);
            currentFrom = currentFrom-ITEM_PER_PAGE;
        }
        if(allTrackInRange.size()==0) {
            allTrackInRange = trackService.obtainTracksByIdRangeFrom(Long.valueOf(currentFrom),Long.valueOf(currentFrom+ITEM_PER_PAGE-1));
            currentFrom = Integer.parseInt(fromIndex);
        }

        List<Double> scores = new ArrayList<>();
        allTrackInRange.forEach((track) -> {
            Long tid = track.getId();
            scores.add(trackService.getAverageScore(tid).isPresent() ? trackService.getAverageScore(tid).get() :(Double) 0d);
        });
        theModel.addAttribute("notFirstPage", currentFrom!=0);
        theModel.addAttribute("fromIndex", currentFrom);
        theModel.addAttribute("trackList", allTrackInRange);
        theModel.addAttribute("scores", scores);
        return "tracks";
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public String getArtistTrack(@PathVariable("id") Long id, Model theModel) {
        Track theTrack = trackService.findById(id);
        Double score = trackService.getAverageScore(theTrack.getId()).isPresent() ? trackService.getAverageScore(theTrack.getId()).get() : 0d;
        theModel.addAttribute("track", theTrack);
        theModel.addAttribute("avgScore", score);
        return "track";
    }


    @RequestMapping(value = {"/{id}"}, method = RequestMethod.POST)
    public String setTrackRate(@PathVariable("id") Long id, @RequestParam("rateScore") int rateScore, Model theModel) {
        Long trackId = id;
        int score = rateScore;
        String username = FindUsername.findLoggedInUsername();
        User user = userService.findByUsername(username);
        Long uid = user.getId();
        Rate theRate = new Rate(uid, trackId, score);
        trackService.saveRate(theRate);
        return "redirect:/track/" + id;
    }

}

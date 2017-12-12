package com.hellokoding.account.web;

import com.hellokoding.account.model.Artist;
import com.hellokoding.account.model.Rate;
import com.hellokoding.account.model.Track;
import com.hellokoding.account.model.User;
import com.hellokoding.account.service.FindUsername;
import com.hellokoding.account.service.TrackService;
import com.hellokoding.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/track")
public class TrackController {

    @Autowired
    private TrackService trackService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public String getArtistTrack(@PathVariable("id") Long id, Model theModel) {
        Track theTrack = trackService.findById(id);
        theModel.addAttribute("track", theTrack);
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

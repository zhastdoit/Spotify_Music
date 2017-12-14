package com.hellokoding.account.web;

import com.hellokoding.account.model.Album;
import com.hellokoding.account.model.Track;
import com.hellokoding.account.service.AlbumService;
import com.hellokoding.account.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(value = {"/album"}, method = RequestMethod.GET)
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private TrackService trackService;

    @RequestMapping(value = {"/all"}, method = RequestMethod.GET)
    public String showPlaylist(Model theModel) {
        List<Album> theAlbum = albumService.getAlbumList();
        theModel.addAttribute("albums", theAlbum);
        return "albums";
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public String getTrackListByPlaylist(@PathVariable("id") Long id, Model theModel) {
        Album theAlbum = albumService.getAlbumWithAlid(id);
        List<Track> albumTrack = trackService.getTrackByAlbum(id);
        List<Double> scores = new ArrayList<>();
        albumTrack.forEach((track) -> {
            Long tid = track.getId();
            scores.add(trackService.getAverageScore(tid).isPresent() ? trackService.getAverageScore(tid).get() :(Double) 0d);
        });
        theModel.addAttribute("trackList", albumTrack);
        theModel.addAttribute("scores", scores);
        theModel.addAttribute("album", theAlbum);
        return "album-details";

    }

}
